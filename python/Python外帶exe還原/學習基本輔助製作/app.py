import sys
import threading
from PyQt5.QtWidgets import QApplication, QMessageBox, QWidget
from UI import Ui_Form
from pymem import *
from pymem.process import *
from time import sleep

class AppWindow(QWidget):

    def __init__(self):
        super().__init__()
        self.ui = Ui_Form()
        self.ui.setupUi(self)
        self.lang = self.ui.lang
        self.language = {'zh_TW':{'scan':['掃描', '已掃描到遊戲',],
                             'error':['錯誤', '請先開啟遊戲後再按偵測程式']},
                             
                    'en':{'scan':['Scen','Scan Completed'],
                          'error':['Error','Please start the game first, then click the detect button']}
                          
        }
        #偵測按鈕
        self.ui.page_button.clicked.connect(self.find_windows)  
        
        #stage1
        self.ui.stage_1[0].clicked.connect(lambda: self.threading_function('stage1_HP'))
        self.ui.stage_1[1].clicked.connect(lambda: self.threading_function('stage1_EX'))
        self.ui.stage_1[2].clicked.connect(lambda: self.threading_function('stage1_range'))  
        
        #stage2
        self.ui.stage_2[0].clicked.connect(lambda: self.threading_function('stage2_HP'))
        self.ui.stage_2[1].clicked.connect(lambda: self.threading_function('stage2_EX'))
        self.ui.stage_2[2].clicked.connect(lambda: self.threading_function('stage2_range'))
        
        #stage3
        self.ui.stage_3[0].clicked.connect(lambda: self.threading_function('stage3_HP'))
        self.ui.stage_3[1].clicked.connect(lambda: self.threading_function('stage3_EX'))
        self.ui.stage_3[2].clicked.connect(lambda: self.threading_function('stage3_range'))
        
        #other
        self.ui.other[0].clicked.connect(lambda: self.threading_function('coin'))
        self.ui.other[1].clicked.connect(lambda: self.threading_function('lavelup'))

        

           
        self.move(40, 40)
        self.show()
        
    def find_windows(self):
        functions = [self.ui.stage_1, self.ui.stage_2, self.ui.stage_3]

        try:
            self.windows = Pymem("HoloCure.exe")
            self.game_module = module_from_name(self.windows.process_handle, "HoloCure.exe").lpBaseOfDll
            for function in functions:
                for enable in function:
                    enable.setEnabled(True) 
                self.ui.other[0].setEnabled(True)
            QMessageBox.information(None, self.language[self.lang]['scan'][0], self.language[self.lang]['scan'][1])
            
        except:
            QMessageBox.critical(None, self.language[self.lang]['error'][0], self.language[self.lang]['error'][1])
            
    def threading_function(self, text):   
        t = threading.Thread(target = self.threading_enable, args = (text,))
        t.setDaemon(True)
        t.start()
    
    def threading_enable(self,text):
        options_info = {
                     'stage1_HP':[self.ui.stage_1[0], 1104006500, 0x006FBD7C,[0x1900,0x140,0x24,0x10,0x990,0x4]],
                     'stage1_EX':[self.ui.stage_1[1], 1104006500, 0x006FBD7C, [0x1900,0x140,0x24,0x10,0xB28,0x04]],
                     'stage1_range':[self.ui.stage_1[2], 1104006500, 0x006FBD7C,[0x1900,0x140,0x24,0x10,0x3E4,0x04]],
                     'stage2_HP':[self.ui.stage_2[0], 1104006500, 0x006FBD7C,[0x1830,0x140,0x24,0x10,0x990,0x04]],
                     'stage2_EX':[self.ui.stage_2[1], 1104006500, 0x006FBD7C, [0x1830,0x140,0x24,0x10,0xB28,0x4]],
                     'stage2_range':[self.ui.stage_2[2], 1104006500, 0x006FBD7C,[0x1830,0x140,0x24,0x10,0x3E4,0x4]],
                     'stage3_HP':[self.ui.stage_3[0], 1104006500, 0x006FBD7C, [0x18FC,0x140,0x24,0x10,0x990,0x04]],
                     'stage3_EX':[self.ui.stage_3[1], 1104006500, 0x006FBD7C, [0x18FC,0x140,0x24,0x10,0xB28,0x4]],
                     'stage3_range':[self.ui.stage_3[2], 1104006500, 0x006FBD7C,[0x18FC,0x140,0x24,0x10,0x3E4,0x4]],
                     'coin':[self.ui.other[0], 1104006500, 0x00705AB4, [0x4,0x0,0x0,0x140,0xC,0x14]],
                     'lavelup':[self.ui.other[1], 1072693248, 0x006FBD7C, [0x18FC,0x10,0x84,0x7C,0x8C,0xC84]],
                    }
        function, value, address, offsets = options_info[text]
        while(1):
            if function.isChecked():
                try:
                    addr  = self.calculate_offsets(self.game_module + address, offsets)
                    if self.windows.read_int(addr) != value:
                        self.windows.write_int(addr, value)
                        #sleep(100/1000)
                except:
                    pass
            else:
                break
    
   
     
    
    
    def calculate_offsets(self, address, offsets):
        addr = self.windows.read_int(address)
        for cnt,offset in enumerate(offsets):
            if cnt+1 != len(offsets):
                addr = self.windows.read_int(addr + offset)           
        return addr + offsets[-1]
        



app = QApplication(sys.argv)
w = AppWindow()
w.show()
sys.exit(app.exec_())
