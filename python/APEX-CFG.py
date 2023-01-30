CFG = [
    # 特別按鍵設置=====================================================================================
    "bind_US_standard 'F2'  'exec autoexec.cfg'											", #重新加載 autoexec (刷新Cfg)
    "bind_US_standard 'F3' 'miles_reboot; miles_stop_all'								", #聲音重製(當發生聲音Bug時 重製遊戲聲音)
    "bind_US_standard 'F5'  'disconnect'												", #段開與伺服器的連接(直接回到伺服器選擇介面)

    # 按鍵設定=======================================================================================

    "bind_US_standard 'space' '+jump; +jump; +jump;'",
    "bind_US_standard 'e' '+use; +use; +use; +use_long; +use_long;'",	
    "bind_US_standard 'mouse5' '+duck; +duck;' 											", #側鍵蹲
    "bind_US_standard 'mwheelup' '+forward; +jump; +forward; +jump;' 					", #滾輪 (跳+前)
    "bind_US_standard 'h' '+scriptCommand5' 											", #短按 輔助技能
    "bind_held_US_standard 'h' '+scriptCommand6'										", #長按 生存道具

    #補品快速鍵設置===================================================================================

    "bind_US_standard '1' 'use_consumable SHIELD_SMALL'									", #短按1拉小電
    "bind_held_US_standard '1' 'use_consumable SHIELD_LARGE' 							", #長按1拉大電
    "bind_US_standard '2' 'use_consumable HEALTH_SMALL'									", #短按2拉小補
    "bind_held_US_standard '2' 'use_consumable HEALTH_LARGE' 							", #長按2拉大補

    #設定靈敏度參數(我的滑鼠DPI:1450)=======================================================================
    "# 平均0.48",
    "m_rawinput '1'																	    ",#滑鼠開啟原始輸入
    "m_filter '0'																		",#禁用滑鼠過濾
    "m_acceleration '0'                                                                 ",#確保滑鼠加速關閉

    "mouse_sensitivity '0.370000' 														",#腰射 edpi:507.5
    "mouse_use_per_scope_sensitivity_scalars '1'										",#是否開啟個別設置倍鏡 1(True) 2(False)
    "mouse_zoomed_sensitivity_scalar_0 '0.510000' 										",#x1倍鏡 edpi:739.5
    "mouse_zoomed_sensitivity_scalar_1 '0.530000' 										",#x2倍鏡 edpi:768.5
    "mouse_zoomed_sensitivity_scalar_2 '0.550000' 										",#x3倍鏡 edpi:797.5
    "mouse_zoomed_sensitivity_scalar_3 '0.570000' 										",#x4倍鏡 edpi:826.5
    "mouse_zoomed_sensitivity_scalar_4 '0.860000'										",#x6倍鏡
    "mouse_zoomed_sensitivity_scalar_5 '0.860000'										",#x8倍鏡
    "mouse_zoomed_sensitivity_scalar_6 '0.860000'										",#x10倍鏡
    "mouse_zoomed_sensitivity_scalar_7 '1.0'											",#不知道衝三小的

    #玩法優化 =======================================================================================

    "cl_showpos '1'																		",#顯示跑速座標等各項數據(1~4可選)
    "#developer '1'																	    ",#開發者模式(失效) 
    "mat_queue_mode '2'																    ",#強製遊戲使用（-1 默認，0 同步單線程，1 排隊單線程，2 多線程）
    "localClientPlayerCachedLevel '25' 													",#修復了當你的隊友看到你為 1 級時無法排位的問題
    "ordnanceSwapSelectCooldown '0'  													",#減少手榴彈交換時間                                       
    "sidearmSwapSelectCooldown '0'														",#減少物品左右交換時間     
    "sidearmSwapSelectDoubleTapTime '0'													",#減少更換武器的時間
    "mat_depthfeather_enable '0'														",#禁用景深                      
    "hud_setting_adsDof '0'																",#禁用向下瞄準時景深
    "cl_matchmaking_timeout '100'  														",#NG匹配超時修復                                      
    "cl_ranked_reconnect_timeout '100' 													",#RK匹配超時修復
    "player_setting_damage_closes_deathbox_menu '0'                                     ",#關閉受到攻擊時死亡箱自動關閉
    "sprint_view_shake_style '1'                                                        ",#Less headbob(不知道中文) 
    "hud_setting_pingDoubleTapEnemy '1'                                                 ",#雙倍的標示敵人
    "fov_disableAbilityScaling '1'                                                      ",#關閉技能fov變化
    "net_netGraph2 '1'                                                                  ",#開啟性能展示
    "weapon_setting_autocycle_on_empty '1'                                              ",#武器自動循環

    #聲音特效======================================================================================="

    "miles_max_sounds_per_server_frame '800'											",#服務器每偵聲音輸出上限
    "miles_channels '2'																	",#輸出雙聲道
    "sound_num_speakers '2'															    ",#喇叭雙聲道
    "snd_mixahead '0.03'																",#減少聲音延遲
    "snd_async_fullyasync '1'															",#聲音同步
    "sound_classic_music '0'															",#經典聲音音量
    "snd_musicvolume '0'																",#聲音音量
    "sound_musicReduced '0'															    ",#遊戲BGM音量			
    "voice_forcemicrecord '0'															",#錄音功能關閉
    "snd_headphone_pan_exponent '2'													    ",#使對的方向聲音你所面會更清晰
    "snd_setmixer PlayerFootsteps vol '0.1'												",#自己腳步聲音量
    "snd_setmixer GlobalFootsteps vol '3'											    ",#別人腳步聲音量
    "cl_footstep_event_max_dist '10000' 												",#增加敵人腳步聲傳遞範圍
    "rope_wind_dist '8000'																",#增大敵人使用繩索的聲音
    "player_setting_enable_heartbeat_sounds '0'                                         ",#禁用席爾的心跳聲
    "sound_volume_music_game '0.000000'												    ",#不知道
    "sound_volume_music_lobby '50.000000'												",#不知道
    "miles_occlusion '0'                                                                ",#以下為取消牆壁吸收音量(可能無效了)
    "miles_occlusion_force '0'",          
    "miles_occlusion_partial '0'",

    #光影效果======================================================================================="

    "mat_light_edit '1'																	#地圖燈光照明",
    "map_settings_override '1'															#設置覆蓋 (不確定幹嘛的)",
    "mat_autoexposure_min '1.9' 														#光照強度最小值",
    "mat_autoexposure_max '1.9' 														#光照強度最大值",
    "mat_autoexposure_speed '2' 														#畫面曝光轉變的速度",
    "mat_hide_sun_in_last_cascade '1' 													#最後一個級聯中的太陽能照明",
    "mat_colcorrection_disableentities '0' 												#更換濾色器（稍微去除離場時“失明”的效果)",
    "mat_autoexposure_max_multiplier '1.7' 												#光強度最大乘數",
    "mat_autoexposure_min_multiplier '1.7' 												#光強度最小的乘數",
    "mat_autoexposure_override_min_max '1'												#曝光最大值最小值",

    #優化FPS======================================================================================="

    "bind_US_standard '8' 'fps_max 120'",
    "bind_US_standard '9' 'fps_max 144'",
    "bind_US_standard '0' 'fps_max 240'",
    "fps_max 240",
    "refresh 240																		#螢幕刷新 240",
    "nomemorybias																	    #減少Ram消耗",
    "cl_forcepreload '1'																#預先載入地圖避免FPS急速掉落",
    "mat_compressedtextures '1' 														#壓縮遊戲裡面的畫質",
    "mat_reduceparticles '0'															#粒子效果關閉",
    "mat_screen_blur_enabled '0'														#螢幕模糊效果關閉",
    "mat_disable_bloom '1'																#禁用綻放特效 (不確定)",
    "cl_ragdoll_collide '0' 															#降低遊戲內死亡後的物理引擎",
    "r_forcewaterleaf '0' 																#水中植被物理引擎降低",
    "r_shadowrendertotexture '0' 														#降低陰影質量 (變的更亮) 0 最低",
    "r_worldlights '0'																	#光源減少",
    "r_dxgi_max_frame_latency '0'														#延遲最大幀",
    "r_maxdlights '0'																	#不知道",
    "nomansky																		    #減少天空渲染",
    "noforcemaccel																	    #不知道",
    "noforcemspd																		#不知道",
    "host_writeconfig																	#不知道",
    "staticProp_max_scaled_dist '1000'													#靜態物體渲染距離",
    "r_particle_timescale '3'                                                           #加速粒子",
    "nx_static_lobby_mode '2'                                                           #減少加載時間",
    "noise_filter_scale '0'                                                             #去除膠片顆粒",
    "cl_show_splashes '0'                                                               #減少水濺效果",
    "fog_enable '0'                                                                     #禁用霧（不是到處禁用）（有效）",
    "fast_fogvolume '1'                                                                 #使用優化的霧渲染",
    "fog_enableskybox '1'                                                               #禁用天空上的霧（減少）（有效）",
    "mat_bloom_scalefactor_scalar '0'                                                   #禁用綻放（減少）（有效）",
    "r_forcecheapwater '1'                                                              #水質下降",
    "r_waterdrawreflection '0'                                                          #禁用水面上的所有反射",
    "r_waterforcereflectentities '0'                                                    #1 = 高（反射所有），0 = 低（減少）(有效)",
    "r_cleardecals '1'                                                                  #清除所有貼花",
    "r_decalstaticprops '0'                                                             #在靜態道具上禁用貼花",
    "shadow_always_update '0'                                                           #禁用陰影檢查",
    "r_shadows '0'                                                                      #陰影  on(1)/off(0)（不完全）（有效）",
    "r_teeth '0'                                                                        #牙齒開（1）/降低質量（0）",
    "r_flex '0'                                                                         #使用面部動畫 on(1)/off(0)",
    "r_maxdlights '0'                                                                   #優化屏幕上可見的動態光的最大數量",
    "stream_drop_unused '1'                                                             #丟棄未使用的紋理",



]
Auto = open("autoexec.cfg","w")
for i in range(len(CFG)):
    Auto.write(CFG[i]+"\n")
    print(CFG[i]+"\n")