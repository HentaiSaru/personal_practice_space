from PyQt5 import QtCore, QtWidgets
import locale


class Ui_Form(object):
    def setupUi(self, page):       
        self.loc = locale.getlocale()
        self.lang = locale.getdefaultlocale()[0]
        if self.lang =='zh_TW' or self.lang =='zh':
            self.lang = 'zh_TW'
        else:
            self.lang = 'en'
            
        form_w = 440
        form_h = 300
        page.resize(form_w, form_h)
        language = {'zh_TW':{'ui_name':'HoloCure修改器 by AUSTIN2526',
                          'info':'【啟動遊戲後按偵測按鈕遊戲即可啟用功能】',
                          'detect_button':'偵測遊戲',
                          'func_name':['鎖血無敵','無限特殊技能','全圖撿物'],
                          'other_func':['無限HoloCoin','無限升級(移除)'],
                          'stage_1':'關卡 1',
                          'stage_2':'關卡 2',
                          'stage_3':'關卡 1 (Hard)',
                          'other':'其他'},
                    'en':{'ui_name':'HoloCure Trainer  by AUSTIN2526',
                          'info':'【Pleas click the detect button to enable function】',
                          'detect_button':'Detect',
                          'func_name':['Unlimited HP','Unlimited SP','EX Pick Range'],
                          'other_func':['Unlimited Coin','Unlimited EXP(remove)'],
                          'stage_1':'Stage 1',
                          'stage_2':'Stage 2',
                          'stage_3':'Stage 1 (Hard)',
                          'other':'other'}
                          
        }
        
        page.setWindowTitle(language[self.lang]['ui_name'])
        
        self.makelabel(page, 105, 10, 2000, 30,language[self.lang]['info'])
        #偵測遊戲
        self.page_button = QtWidgets.QPushButton(page)
        self.page_button.setGeometry(QtCore.QRect(10,10,100,30))
        self.page_button.setText(language[self.lang]['detect_button'])
        
        #第一關數據
        func_name = language[self.lang]['func_name']
        self.makelabel(page, 10, 50, 2000, 30,language[self.lang]['stage_1'])
        self.stage_1 = []
        for index in range(3):
            self.stage_1.append(QtWidgets.QCheckBox(page))
            self.stage_1[index].setGeometry(QtCore.QRect(10 + 140*index, 80 , 2000, 30))
            self.stage_1[index].setText(func_name[index])
            self.stage_1[index].setEnabled(False)
            
        #第二關數據
        func_name = language[self.lang]['func_name']
        self.makelabel(page, 10, 110, 2000, 30,language[self.lang]['stage_2'])
        self.stage_2 = []
        for index in range(len(func_name)):
            self.stage_2.append(QtWidgets.QCheckBox(page))
            self.stage_2[index].setGeometry(QtCore.QRect(10 + 140*index, 140 , 2000, 30))
            self.stage_2[index].setText(func_name[index])
            self.stage_2[index].setEnabled(False)
            
        #第三關數據
        func_name = language[self.lang]['func_name']
        self.makelabel(page, 10, 170, 2000, 30,language[self.lang]['stage_3'])
        self.stage_3 = []
        for index in range(len(func_name)):
            self.stage_3.append(QtWidgets.QCheckBox(page))
            self.stage_3[index].setGeometry(QtCore.QRect(10 + 140*index, 200 , 2000, 30))
            self.stage_3[index].setText(func_name[index])
            self.stage_3[index].setEnabled(False)
        
        #其他功能
        func_name = language[self.lang]['other_func']
        self.makelabel(page, 10, 230, 2000, 30,language[self.lang]['other'])
        self.other = []
        for index in range(len(func_name)):
            self.other.append(QtWidgets.QCheckBox(page))
            self.other[index].setGeometry(QtCore.QRect(10 + 140*index, 260 , 2000, 30))
            self.other[index].setText(func_name[index])
            self.other[index].setEnabled(False)
           
    def makelabel(self, page, x=10, y=10, w=10, h=20, text='', s=True):
        self.label = QtWidgets.QLabel(page)
        self.label.setGeometry(QtCore.QRect(x, y, w, h))
        self.label.setObjectName('label')
        self.label.setText(text)
        self.label.setEnabled(s)

