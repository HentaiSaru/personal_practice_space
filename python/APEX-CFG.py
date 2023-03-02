import configparser as config
import tkinter as tk
from tkinter import filedialog
import os

CFG = [
    # 特別按鍵設置=====================================================================================
    'bind_US_standard "F2"  "exec autoexec.cfg"											',# 重新加載 autoexec (刷新Cfg)
    'bind_US_standard "F3" "miles_reboot; miles_stop_all"								',# 聲音重製(當發生聲音Bug時 重製遊戲聲音)
    'bind_US_standard "F5"  "disconnect"												',# 段開與伺服器的連接(直接回到伺服器選擇介面)

    # 按鍵設定=======================================================================================

    'bind_US_standard "x" "+ping"                                                       ',  # 使用X ping點
    'bind_US_standard "space" "+jump; +jump; +jump;"                                    ',
    'bind_US_standard "e" "+use; +use; +use; +use_long; +use_long;"                     ',
    'bind_US_standard "MOUSE4" "+melee"                                                 ',  # 側鍵近戰
    'bind_US_standard "mouse5" "+duck; +duck;" 											',  # 側鍵蹲
    'bind_US_standard "mwheelup" "+forward; +jump; +forward; +jump;" 					',  # 滾輪 (跳+前)
    'bind_US_standard "h" "+scriptCommand5" 											',  # 短按 輔助技能
    'bind_held_US_standard "h" "+scriptCommand6"										',  # 長按 生存道具

    # 補品快速鍵設置===================================================================================

    'bind_US_standard "1" "use_consumable SHIELD_SMALL"									',  # 短按1拉小電
    'bind_held_US_standard "1" "use_consumable SHIELD_LARGE" 							',  # 長按1拉大電
    'bind_US_standard "2" "use_consumable HEALTH_SMALL"									',  # 短按2拉小補
    'bind_held_US_standard "2" "use_consumable HEALTH_LARGE" 							',  # 長按2拉大補

    # 設定靈敏度參數(我的滑鼠DPI:1450)=======================================================================
    # 平均0.48
    'm_acceleration "0"                                                                 ',  # 確保滑鼠加速關閉

    'mouse_sensitivity "0.400000" 														',  # 腰射 edpi:
    'mouse_use_per_scope_sensitivity_scalars "1"										',  # 是否開啟個別設置倍鏡 1(True) 2(False)
    'mouse_zoomed_sensitivity_scalar_0 "0.510000" 										',  # x1倍鏡 edpi:739.5
    'mouse_zoomed_sensitivity_scalar_1 "0.530000" 										',  # x2倍鏡 edpi:768.5
    'mouse_zoomed_sensitivity_scalar_2 "0.550000" 										',  # x3倍鏡 edpi:797.5
    'mouse_zoomed_sensitivity_scalar_3 "0.570000" 										',  # x4倍鏡 edpi:826.5
    'mouse_zoomed_sensitivity_scalar_4 "0.860000"										',  # x6倍鏡
    'mouse_zoomed_sensitivity_scalar_5 "0.860000"										',  # x8倍鏡
    'mouse_zoomed_sensitivity_scalar_6 "0.860000"										',  # x10倍鏡
    'mouse_zoomed_sensitivity_scalar_7 "1.0"											',  # 不知道衝三小的

    
    # 玩法優化 =======================================================================================

    'cl_showpos "1"																		',  # 顯示跑速座標等各項數據(1~4可選)
    # developer "1"																	        #開發者模式(失效)
    'mat_queue_mode "2"																    ',  # 強製遊戲使用（-1 默認，0 同步單線程，1 排隊單線程，2 多線程）
    'localClientPlayerCachedLevel "25" 													',  # 修復了當你的隊友看到你為 1 級時無法排位的問題
    'ordnanceSwapSelectCooldown "0"  													',  # 減少手榴彈交換時間
    'sidearmSwapSelectCooldown "0"														',  # 減少物品左右交換時間
    'sidearmSwapSelectDoubleTapTime "0"													',  # 減少更換武器的時間
    'mat_depthfeather_enable "0"														',  # 禁用景深
    'hud_setting_adsDof "0"																',  # 禁用向下瞄準時景深
    'cl_matchmaking_timeout "100"  														',  # NG匹配超時修復
    'cl_ranked_reconnect_timeout "100" 													',  # RK匹配超時修復
    'player_setting_damage_closes_deathbox_menu "0"                                     ',  # 關閉受到攻擊時死亡箱自動關閉
    'sprint_view_shake_style "1"                                                        ',  # Less headbob(不知道中文)
    'hud_setting_pingDoubleTapEnemy "1"                                                 ',  # 雙倍的標示敵人
    'fov_disableAbilityScaling "1"                                                      ',  # 關閉技能fov變化
    'net_netGraph2 "1"                                                                  ',  # 開啟性能展示
    'weapon_setting_autocycle_on_empty "1"                                              ',  # 武器自動循環

    # 聲音特效=======================================================================================

    'miles_max_sounds_per_server_frame "800"											',  # 服務器每偵聲音輸出上限
    'miles_channels "2"																	',  # 輸出雙聲道
    'sound_num_speakers "2"															    ',  # 喇叭雙聲道
    'snd_mixahead "0.03"																',  # 減少聲音延遲
    'snd_async_fullyasync "1"															',  # 聲音同步
    'sound_classic_music "0"															',  # 經典聲音音量
    'snd_musicvolume "0"																',  # 聲音音量
    'sound_musicReduced "0"															    ',  # 遊戲BGM音量
    'voice_forcemicrecord "0"															',  # 錄音功能關閉
    'snd_headphone_pan_exponent "2"													    ',  # 使對的方向聲音你所面會更清晰
    'snd_setmixer PlayerFootsteps vol "0.1"												',  # 自己腳步聲音量
    'snd_setmixer GlobalFootsteps vol "3"											    ',  # 別人腳步聲音量
    'cl_footstep_event_max_dist "10000" 												',  # 增加敵人腳步聲傳遞範圍
    'rope_wind_dist "8000"																',  # 增大敵人使用繩索的聲音
    'player_setting_enable_heartbeat_sounds "0"                                         ',  # 禁用席爾的心跳聲
    'sound_volume_music_game "0.000000"												    ',  # 不知道
    'sound_volume_music_lobby "50.000000"												',  # 不知道
    'miles_occlusion "0"                                                                ',  # 以下為取消牆壁吸收音量(可能無效了)
    'miles_occlusion_force "0"',
    'miles_occlusion_partial "0"',

    # 光影效果=======================================================================================

    'mat_light_edit "1"																	',  # 地圖燈光照明
    'map_settings_override "1"															',  # 設置覆蓋 (不確定幹嘛的)
    'mat_autoexposure_min "1.9" 														',  # 光照強度最小值
    'mat_autoexposure_max "1.9" 														',  # 光照強度最大值
    'mat_autoexposure_speed "2" 														',  # 畫面曝光轉變的速度
    'mat_hide_sun_in_last_cascade "1" 													',  # 最後一個級聯中的太陽能照明
    'mat_colcorrection_disableentities "0" 												',  # 更換濾色器（稍微去除離場時“失明”的效果)
    'mat_autoexposure_max_multiplier "1.7" 												',  # 光強度最大乘數
    'mat_autoexposure_min_multiplier "1.7" 												',  # 光強度最小的乘數
    'mat_autoexposure_override_min_max "1"												',  # 曝光最大值最小值

    # 優化FPS=======================================================================================

    'bind_US_standard "8" "fps_max 120"',
    'bind_US_standard "9" "fps_max 144"',
    'bind_US_standard "0" "fps_max 240"',
    'fps_max 240',
    'refresh 240																		',  # 螢幕刷新 240
    'nomemorybias																	    ',  # 減少Ram消耗
    'cl_forcepreload "1"																',  # 預先載入地圖避免FPS急速掉落
    'mat_compressedtextures "1" 														',  # 壓縮遊戲裡面的畫質
    'mat_reduceparticles "0"															',  # 粒子效果關閉
    'mat_screen_blur_enabled "0"														',  # 螢幕模糊效果關閉
    'mat_disable_bloom "1"																',  # 禁用綻放特效 (不確定)
    'cl_ragdoll_collide "0" 															',  # 降低遊戲內死亡後的物理引擎
    'r_forcewaterleaf "0" 																',  # 水中植被物理引擎降低
    'r_shadowrendertotexture "0" 														',  # 降低陰影質量 (變的更亮) 0 最低
    'r_worldlights "0"																	',  # 光源減少
    'r_dxgi_max_frame_latency "0"														',  # 延遲最大幀
    'r_maxdlights "0"																	',  # 不知道
    'nomansky																		    ',  # 減少天空渲染
    'noforcemaccel																	    ',  # 不知道
    'noforcemspd																		',  # 不知道
    'host_writeconfig																	',  # 不知道
    'staticProp_max_scaled_dist "1000"													',  # 靜態物體渲染距離
    'r_particle_timescale "3"                                                           ',  # 加速粒子
    'nx_static_lobby_mode "2"                                                           ',  # 減少加載時間
    'noise_filter_scale "0"                                                             ',  # 去除膠片顆粒
    'cl_show_splashes "0"                                                               ',  # 減少水濺效果
    'fog_enable "0"                                                                     ',  # 禁用霧（不是到處禁用）（有效）
    'fast_fogvolume "1"                                                                 ',  # 使用優化的霧渲染
    'fog_enableskybox "1"                                                               ',  # 禁用天空上的霧（減少）（有效）
    'mat_bloom_scalefactor_scalar "0"                                                   ',  # 禁用綻放（減少）（有效）
    'r_forcecheapwater "1"                                                              ',  # 水質下降
    'r_waterdrawreflection "0"                                                          ',  # 禁用水面上的所有反射
    'r_waterforcereflectentities "0"                                                    ',  # 1 = 高（反射所有），0 = 低（減少）(有效)
    'r_cleardecals "1"                                                                  ',  # 清除所有貼花
    'r_decalstaticprops "0"                                                             ',  # 在靜態道具上禁用貼花
    'shadow_always_update "0"                                                           ',  # 禁用陰影檢查
    'r_shadows "0"                                                                      ',  # 陰影  on(1)/off(0)（不完全）（有效）
    'r_teeth "0"                                                                        ',  # 牙齒開（1）/降低質量（0）
    'r_flex "0"                                                                         ',  # 使用面部動畫 on(1)/off(0)
    'r_maxdlights "0"                                                                   ',  # 優化屏幕上可見的動態光的最大數
    'stream_drop_unused "1"                                                             ',  # 丟棄未使用的紋理

    # 網路優化(loss丟失/choke阻塞)=======================================================================
    
    'host_limitlocal "1"															    ',  # 是否關閉使用本地DNS
    'rate "125000"																	    ',  # https//:agame01.com/article/682994/
    'cl_cmdrate "100"																    ',  # 每秒上傳幾組 packet 到 server (丟包loss時降低)
    'cl_updaterate "100"															    ',  # 每秒向 server 接收幾組 packet (阻塞choke時降低)
    'cl_lagcompensation "1"															    ',  # 延遲補償開啟
    'cl_resend "2"																	    ',  # 網路錯誤重發間隔
    'cl_interp "0"																	    ',  # 網路插播關閉
    'cl_interp_ratio "1"															    ',  # 間格比(數值加大減少丟包)
    'cl_pred_optimize "1"															    ',  # 預優化?
    'cl_predict "1"																	    ',  # 不確定
    'cl_predictweapons "1"															    ',  # 不確定
    'cl_wpn_sway_interp "0"															    ',  # wpn搖擺解釋器
    'cl_interpolate "0"																    ',  # 不知道
    'cl_interpolation_before_prediction "0"											    ',  # 不知道
    'cl_cmdbackup "2"																    ',  # 數據包丟失備份發送
    'cl_updatevisibility "1"														    ',  # 更新可見性
    'cl_timeout "25"																    ',  # 超時請求
    'cl_smooth "1"																	    ',  # 不知道
    'cl_smoothtime "0.01"															    ',  # 不知道
    'pin_opt_in "0"																	    ',  # 禁止將 PIN 遙測數據發送到 EA
    'pin_plat_id "0"																    ',  # 退出重生數據調查
    'telemetry_client_enable "0"													    ',  # 多久發送一次遙測數據
    'projectile_prediction " 1 "													    ',  # 啟用客戶端預測和彈丸補償
    'projectile_predictionErrorCorrectTime " 0.01 "									    ',  # 修正彈丸預測誤差的時間
    'origin_presense_updateRate " 10 "												    ',  # 在每次 Origin 存在更新之間放寬秒數
    'net_compresspackets " 1 "														    ',  # 壓縮發送到服務器的數據包
    'net_compresspackets_minsize " 64 "												    ',  # 壓縮包不低於設定值
    'net_maxcleartime " 0.030000 "													    ',  # 減少引擎等待發送另一個數據包的時間
    'host_sleep "0"																	    ',  # 強製主機每幀休眠一定的毫秒數'''
    'telemetry_client_sendInterval "0"',

]

# ===================================================上面才是設定值,下面不用觀看=============================================================

""" 
Versions 1.2
- 修復了例外Bug
- 修復環境差異造成的例外
- 重構了一小部份代碼

預計增加
+ UI介面
+ 更易維護與觀看的代碼

"""

os.system('color A')
os.system('@echo off')
os.system('cls')
os.system('@ ECHO.')
os.system('@ ECHO.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ APEX-CFG設置程序 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')
os.system('@ ECHO                                                   適用於15賽季')
os.system('@ ECHO.')
os.system('@ ECHO                                                     使用說明')
os.system('@ ECHO.')
os.system('@ ECHO                               最多可設置兩個路徑,第一次設置完成後,之後就不會再跳出設置了')
os.system('@ ECHO.')
os.system('@ ECHO                            需要重新設置的,就將生成的[CFG_Set.ini]刪除掉,程式運行完再按一次關閉')
os.system('@ ECHO.')
os.system('@ ECHO -----------------------------------------------------------------------------------------------------------------------')
os.system('@ ECHO                                                按任意鍵開始運行程式')
os.system('@ ECHO -----------------------------------------------------------------------------------------------------------------------')
os.system('@ ECHO.')
os.system('pause')
os.system('cls')

def fac(path):
    with open(path, 'w') as Auto:
        for output in CFG:
            Auto.write(output + '\n')

# ========== 讀取設置檔 ==========
try:

    """FileSet = "./CFG_Set.ini"
    InSet = config.ConfigParser()
    #InSet.read(FileSet, encoding='utf-8')

    path1 = InSet.get("set","path1")
    path2 = InSet.get("set","path2")"""

    # 因環境不同有解析失敗的問題,改成直接讀取
    with open('CFG_Set.ini', 'r') as c:
        contents = c.read()

    InSet = config.ConfigParser()
    InSet.read_string(contents)

    path1 = InSet.get('set', 'path1')
    path2 = InSet.get('set', 'path2')

    fac(path1)

# ========== 判斷設置檔是否存在第二項位置 ==========
    if path2.lower() != "null":
        fac(path2)

    elif path2.lower() == "null":
        pass

except (FileNotFoundError, config.ParsingError) as e:
# ========== 因為無檔案所有創建一個 ==========
    filename = "/autoexec.cfg"
    file = open('CFG_Set.ini', 'w')

    FileSet = "./CFG_Set.ini"
    InSet = config.ConfigParser()
    InSet.read(FileSet , "UTF-8")

    """也可使用 file.write("[set]\n") 去進行寫入,這方法較為簡單"""
    InSet.add_section('set')

    root = tk.Tk()
    root.withdraw()
    
# ========== 開始設置 ==========
    print('請選擇您的APEX資料夾,內的CFG資料夾的')
    # 選擇文件 -> askopenfilename()  選擇資料夾 -> askdirectory()
    path1 = filedialog.askdirectory()

    # 改成讀取到選擇位置後,直接在該路徑創建 .cfg 且隨意寫入個東西
    Cfg_File = os.path.join(path1,'autoexec.cfg')
    with open(Cfg_File, 'w') as cfg_file:
       cfg_file.write('\n')

    # 創建完後再將字串加入,寫入至設定ini檔保存
    path1+=filename

# ========== 第二項設置詢問 ==========
    path2 = input('是否需要設置第二個位置(Y/N):')
    
# ========== 怕有額外的錯誤使用except ==========
    """舊版的手動輸入,要讓設置檔的路徑顯示是反斜 \\ 可以這樣打"""  

    try:

        # ===== 輸入是y時 ===== 
        if path2.lower() == 'y':
            path2 = filedialog.askdirectory()
            Cfg_File = os.path.join(path2,'autoexec.cfg')

            with open(Cfg_File, 'w') as cfg_file:
                cfg_file.write('\n')

            path2+=filename

        # ===== 輸入是n時,在ini設置寫入NULL ===== 
        elif path2.lower() == 'n':
            path2 = "NULL" 

        # ===== 有正常輸入時,設置寫入位置,然後呼叫輸出方法 =====
        else:
            print("輸入錯誤 , 請輸入 Y 或 N")
            pass

        # ===== (原本是手動輸入的驗證,改成直接選擇這邊就非必要了) =====
        if os.path.isfile(path1) and os.path.isfile(path2):
            
            InSet.set('set','path1', path1) #將輸入的路徑位置設置寫入
            InSet.set('set','path2', path2)

            fac(path1)
            fac(path2)
        
        elif os.path.isfile(path1) and path2 == "NULL":

            InSet.set('set','path1', path1) #將輸入的路徑位置設置寫入
            InSet.set('set','path2', path2)

            fac(path1)

        else:
            raise InvalidFilePathError()
        
        # ===== 通過驗證後最後將路徑寫入至Config =====
        file.close()
        with open(FileSet, 'w') as configfile:InSet.write(configfile)

        print('運行成功')
        input('\n按任意鍵結束運行...')
        os._exit(0)

    except:

        file.close()
        os.system('cls')
        print('運行錯誤,請重新運行\n')

        os.system("del /f /s /q CFG_Set.ini >nul 2>&1") #採用靜默刪除指令
        input('\n按任意鍵結束運行...')

print('運行成功')
input('\n按任意鍵結束運行...')