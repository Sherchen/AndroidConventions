Table of Contents
=================

  * [1. AS规范](#1-as规范)
     * [1.1 CopyRight](#11-copyright)
     * [1.2 模板](#12-模板)
     * [1.3 全局管理gradle变量。](#13-全局管理gradle变量)
  * [2. 工程结构](#2-工程结构)
     * [2.1 Java层结构](#21-java层结构)
     * [2.2 android res层结构](#22-android-res层结构)
  * [3. Android资源命名规范](#3-android资源命名规范)
     * [3.1 文件命名](#31-文件命名)
        * [3.1.1 layout命名](#311-layout命名)
        * [3.1.2 drawable命名](#312-drawable命名)
        * [3.1.3 其他文件命名](#313-其他文件命名)
     * [3.2 文件下面的name 命名](#32-文件下面的name-命名)
        * [3.2.1 layout ID命名](#321-layout-id命名)
        * [3.2.2 color 命名](#322-color-命名)
        * [3.2.3 dimen命名](#323-dimen命名)
        * [3.2.4 string命名](#324-string命名)
        * [3.2.5 style命名](#325-style命名)
  * [4. Java规范](#4-java规范)
     * [4.1 Java文件命名规范](#41-java文件命名规范)
     * [4.2 Java编码规范](#42-java编码规范)
        * [4.2.1 字段(field)命名](#421-字段field命名)
        * [4.2.2 方法命名](#422-方法命名)
     * [4.3 编码习惯](#43-编码习惯)
        * [4.3.1 不要忘记添加注释](#431-不要忘记添加注释)
        * [4.3.2 不要忘记处理异常](#432-不要忘记处理异常)
        * [4.3.3 方法名称不要太长](#433-方法名称不要太长)
        * [4.3.4 方法参数不要太多](#434-方法参数不要太多)
        * [4.3.5 方法行数不要太多。](#435-方法行数不要太多)
        * [4.3.6 更多规范](#436-更多规范)
  * [5. 附录](#5-附录)
     * [UI控件缩写表](#ui控件缩写表)
     * [常见的英文单词缩写表](#常见的英文单词缩写表)
  * [参考](#参考)
## 1. AS规范
### 1.1 CopyRight
在Settings/Editor/CopyRight里添加一份，内容你可以在github上找一份，改下，这样每次新增文件，IDE都会自动加上CopyRight.
### 1.2 模板
在Settings/Editor/File and Code Templates右侧的includes/File header下修改，比如我的

```
/**
 * <pre>
 *     author : Sherchen
 *     e-mail : ncuboy_045wsq@qq.com
 *     time   : ${DATE}
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */
```
每创建一个新的java文件，IDE就会自动加上，不要忘记修改desc, version等。
### 1.3 全局管理gradle变量。
一般都是在root project下面的build.gradle的文件末尾追加，比如我的

```
ext {
    minSdkVersion = 9
    targetSdkVersion = 22
    buildToolsVersion = '25.0.2'
    compileSdkVersion = 25
}
```
引用的时候，比如在app module下面的build.gradle，比如：

```
android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion
}
```

## 2. 工程结构
包括java层和android res层
### 2.1 Java层结构
我采用的是package by feature(PBF)分层方式，[你可以PBF的介绍](https://hackernoon.com/package-by-features-not-layers-2d076df1964d)

![image](https://github.com/Sherchen/AndroidConventions/blob/master/avatar/PBF.png)

### 2.2 android res层结构
为了方便阅读和模块化开发的团队分工，我把android res目录按照模块拆分成几个，使用代码如下

```
sourceSets {
        main {
            res.srcDirs = [
                    'src/main/res',//common
                    'src/main/res-home',//for home module
                    'src/main/res-cnblog',//for cnblog module
                    'src/main/res-csdn', //for csdn module
                    'src/main/res-github', //for github module
                    'src/main/res-jianshu' //for jianshu module
            ]
        }
}
```
拆分后的android res 视图如下

![image](https://github.com/Sherchen/AndroidConventions/blob/master/avatar/android-res.png)

## 3. Android资源命名规范
### 3.1 文件命名
####    3.1.1 layout命名    
layout的一般命名规则是<what>_<where>_<desc>，比如下面

| Component 组件  | Class Name             | Layout Name                   |
| ---------------- | ---------------------- | ----------------------------- |
| Activity         | `HomeActivity`  | `activity_home.xml`   |
| Fragment         | `HomeTopFragment`       | `fragment_home_top.xml`        |
| Dialog           | `HomeUpgradeDialog` | `dialog_home_upgrade.xml`  |
| AdapterView Item | ---                    | `item_csdn.xml`             |
| include(通用组件)          | ---                    | `include_list`                        |

####    3.1.2 drawable命名
 >drawable 文件的命名规范
 
 | Asset Type   | Prefix 前缀           |		Example               |
 |--------------| ------------------|-----------------------------|
 | Action bar   | `ab_`             | `ab_stacked.9.png`          |
 | Button       | `btn_`	            | `btn_send_pressed.9.png`    |
 | Dialog       | `dialog_`         | `dialog_top.9.png`          | 
 | Divider      | `divider_`        | `divider_horizontal.9.png`  |
 | Icon         | `ic_`	            | `ic_star.png`               |
 | Menu         | `menu_	`           | `menu_submenu_bg.9.png`     |
 | Notification | `notification_`   	| `notification_bg.9.png`     |
 | Tabs         | `tab_`            | `tab_pressed.9.png`         |


 >icons文件的命名规范

| Asset Type                      | Prefix 前缀            | Example                      |
| --------------------------------| ----------------   | ---------------------------- | 
| Icons                           | `ic_`              | `ic_star.png`                |
| Launcher icons                  | `ic_launcher`      | `ic_launcher_calendar.png`   |
| Menu icons and Action Bar icons | `ic_menu`          | `ic_menu_archive.png`        |
| Status bar icons                | `ic_stat_notify`   | `ic_stat_notify_msg.png`     |
| Tab icons                       | `ic_tab`           | `ic_tab_recent.png`          |
| Dialog icons                    | `ic_dialog`        | `ic_dialog_info.png`         |


 >选择器状态文件的命名规范

| State	       | Suffix  尾缀        | Example                     |
|--------------|-----------------|-----------------------------|
| Normal       | `_normal`       | `btn_order_normal.9.png`    |
| Pressed      | `_pressed`      | `btn_order_pressed.9.png`   |
| Focused      | `_focused`      | `btn_order_focused.9.png`   |
| Disabled     | `_disabled`     | `btn_order_disabled.9.png`  |
| Selected     | `_selected`     | `btn_order_selected.9.png`  |

#### 3.1.3 其他文件命名
- menu 因为menu文件较少，而且都在一个menu目录下面，所以一般命名就是<what>.xml，比如home.xml
- anim 直接命名，比如: fade_in.xml
- values 目录下面的文件,使用复数形式,比如: arrays.xml, attrs.xml, colors.xml, configs.xml, dimens.xml, strings.xml, styles.xml

### 3.2 文件下面的name 命名
#### 3.2.1 layout ID命名
一般规则：<what>_<where>_<desc>, 比如android:id="tv_home_display",这里的what,一般使用控件单词的缩写，参考[5 附录](#5-附录)

#### 3.2.2 color 命名
直接定义颜色值，比如

```
<color name="white"     >#FFFFFF</color>
<color name="gray_light">#DBDBDB</color>
<color name="gray"      >#939393</color>
<color name="gray_dark" >#5F5F5F</color>
<color name="black"     >#323232</color>
```
#### 3.2.3 dimen命名
一般规则: <what>_<where>_<size>，如果不需要特殊定义这个dimen在哪个模块使用，<where>可以省略，比如


```
<!-- font sizes -->
<dimen name="font_22">22sp</dimen>

<!-- typical spacing between two views -->
<dimen name="spacing_40">40dp</dimen>

<!-- typical sizes of views -->
<dimen name="button_height_60">60dp</dimen>

```

#### 3.2.4 string命名
一般规则: <where>_<desc>，比如

```
<!--通用模块-->
<string name="loading">加载中...</string>
<string name="ok">确认</string>
<string name="cancel">取消</string>

<!--home模块-->
<string name="home_tab_hot">热点</string>
<string name="home_tab_find">发现</string>
<string name="home_tab_nearby">附近</string>
```
#### 3.2.5 style命名
一般规则：<what>.<Desc>,比如

```
<style name="ImageView"></style>

<style name="ImageView.Icon">
    <item name="android:padding">8dp</item>
</style>

<style name="TextView">
    <item name="android:textColor">#212121</item>
    <item name="android:textSize">14px</item>
</style>

<style name="TextView.12">
    <item name="android:textSize">12px</item>
</style>
```

## 4. Java规范
### 4.1 Java文件命名规范

类名都以`UpperCamelCase`风格编写。

类名通常是名词或名词短语，接口名称有时可能是形容词或形容词短语。现在还没有特定的规则或行之有效的约定来命名注解类型。

名词，采用大驼峰命名法，尽量避免缩写，除非该缩写是众所周知的， 比如`HTML`, `URL`，如果类名称中包含单词缩写，则单词缩写的每个字母均应大写。

| 类                  | 描述                                       | 例如                                       |
| :----------------- | :--------------------------------------- | :--------------------------------------- |
| Activity 类         | Activity为后缀标识                            | 欢迎页面类WelcomeActivity                     |
| Fragment 类         | Fragment为后缀标识                            | 主页顶部类HomeTopFragment                     |
| Dialog 类         | Dialog为后缀标识                            | 升级对话框类UpgradeDialog                     |
| Adapter类           | Adapter 为后缀标识                            | 新闻详情适配器 NewDetailAdapter                 |
| 解析类                | Parser为后缀标识                              | 首页解析类HomePosterParser                    |
| 工具方法类              | Utils或Manager为后缀标识（与系统或第三方的Utils区分）或功能+Utils | 线程池管理类：ThreadPoolManager日志工具类：LogUtils（Logger也可）打印工具类：PrinterUtils |
| 数据库类               | 以DBHelper后缀标识                            | 新闻数据库：NewDBHelper                        |
| Service类           | 以Service为后缀标识                            | 时间服务TimeService                          |
| BroadcastReceiver类 | 以Receiver为后缀标识                           | 推送接收JPushReceiver                        |
| ContentProvider类   | 以Provider为后缀标识                           | ShareProvider                            |
| 自定义的共享基础类          | 以Base开头                                  | BaseActivity,BaseFragment                |

测试类的命名以它要测试的类的名称开始，以Test结束。例如：`HashTest`或`HashIntegrationTest`。

接口（interface）：命名规则与类一样采用大驼峰命名法，多以able或ible结尾，如
`interface Runnable`、`interface Accessible`。

### 4.2 Java编码规范
#### 4.2.1 字段(field)命名
- 类字段，包括变量和常亮
1.   公有变量按 小驼峰 法命名
2.   私有 & 非静态成员变量以 m 开头
3.   私有 & 静态成员变量以 s 开头
4.   常量以大写字母和下划线 _ 组成
5.   尽量使用 类型+功能/描述的模式 ,如 mTvDisplay

    
```
    private TextView mTvDisplay;
    //静态常量
    public static final int SOME_CONSTANT = 42;
    //公有变量
    public int publicField;
    //私有静态变量
    private static String sSingleton;
    //默认变量
    int mPackagePrivate;
    //私有变量
    private int mPrivate;
    //继承型变量
    protected int mProtected;
```
    

- 局部变量
    局部变量名以lowerCamelCase风格编写，比起其它类型的名称，局部变量名可以有更为宽松的缩写。
虽然缩写更宽松，但还是要避免用单字符进行命名，除了临时变量和循环变量。
即使局部变量是final和不可改变的，也不应该把它示为常量，自然也不能用常量的规则去命名它。

- 临时变量通常被取名为i、j、k、m和n，它们一般用于整型；c、d、e，它们一般用于字符型。 如：for (int i = 0; i < len ; i++)。

- 参数名以lowerCamelCase风格编写。 参数应该避免用单个字符命名。




#### 4.2.2 方法命名
- 类方法采用 小驼峰 命名法
- 根据函数所完成功能命名 ， 如 changView()
- 在函数头写对于函数功能、参数和返回值的注释，如：

```
  /**
    * 获取两个数中最大的一个
    *
    * @param value1 参与比较的第一个数
    * @param value2 参与比较的第二个数
    * @return 两个参数中最大的一个数
    */
   public int max(int value1, int value2) {
       return (value1 > value2) ? value1 : value2;
   }
```

### 4.3 编码习惯
#### 4.3.1 不要忘记添加注释

```
/**
 * 获取Sim卡运营商名称
 * <p>中国移动、如中国联通、中国电信</p>
 * @param context 上下文
 * @return 移动网络运营商名称
 */
public static String getSimOperatorByMnc(Context context) {
    ---
}
```
#### 4.3.2 不要忘记处理异常

```
void setServerPort(String value) {
    try {
        serverPort = Integer.parseInt(value);
    } catch (NumberFormatException e) {
        //处理异常结果
    }
}

//不要像下面使用Exception类捕抓异常
try {
    someComplicatedIOFunction();        // may throw IOException
    someComplicatedParsingFunction();   // may throw ParsingException
    // phew, made it all the way
} catch (Exception e) {                 // I'll just catch all exceptions
    handleError();                      // with one generic handler!
}
```
#### 4.3.3 方法名称不要太长
#### 4.3.4 方法参数不要太多
#### 4.3.5 方法行数不要太多。
#### 4.3.6 更多规范可以参考[code-style](https://source.android.com/source/code-style)


## 5. 附录
### UI控件缩写表

| 名称             | 缩写   |
| -------------- | ---- |
| TextView       | tv   |
| EditText       | et   |
| ImageButton    | ib   |
| Button         | btn  |
| ImageView      | iv   |
| ListView       | lv   |
| GridView       | gv   |
| GridLayout       | gl   |
| ProgressBar    | pb   |
| SeekBar        | sb   |
| RadioButtion   | rb   |
| CheckBox       | cb   |
| ScrollView     | sv   |
| LinearLayout   | ll   |
| FrameLayout    | fl   |
| RelativeLayout | rl   |
| RecyclerView   | rv   |
| WebView        | wv   |
| VideoView      | vv   |
| Spinner        | spn  |
| ToggleButton   | tb   |
| 新组件或自定义组件       | 可以根据情况   |

### 常见的英文单词缩写表

| 名称                   | 缩写                                       |
| -------------------- | ---------------------------------------- |
| icon                 | ic （主要用在app的图标）                          |
| color                | cl（主要用于颜色值）                              |
| average              | avg                                      |
| background           | bg（主要用于布局和子布局的背景）                        |
| selector             | sel主要用于某一view多种状态，不仅包括Listview中的selector，还包括按钮的selector） |
| buffer               | buf                                      |
| control              | ctrl                                     |
| default              | def                                      |
| delete               | del                                      |
| document             | doc                                      |
| error                | err                                      |
| escape               | esc                                      |
| increment            | inc                                      |
| infomation           | info                                     |
| initial              | init                                     |
| image                | img                                      |
| Internationalization | I18N                                     |
| length               | len                                      |
| library              | lib                                      |
| message              | msg                                      |
| password             | pwd                                      |
| position             | pos                                      |
| server               | srv                                      |
| string               | str                                      |
| temp                 | tmp                                      |
| window               | wnd(win)                                 |


## 参考
[android官方手册][google-code-style]

[Android包命名规范][Android包命名规范]

[Android 开发最佳实践][Android 开发最佳实践]

[Android 编码规范][Android 编码规范]

[安卓开发规范(updating)][安卓开发规范(updating)]

[Android-Code-Style][Android-Code-Style]

[android-guidelines][android-guidelines]


                ——powered by Sherchen

[Package by features, not layers]: https://hackernoon.com/package-by-features-not-layers-2d076df1964d
[google-code-style]: https://source.android.com/source/code-style
[Android-Code-Style]: https://github.com/LoranWong/Android-Code-Style
[android-guidelines]: https://github.com/ribot/android-guidelines
[iosched]: https://github.com/google/iosched/tree/master/android/src/main/java/com/google/samples/apps/iosched
[安卓开发规范(updating)]: https://github.com/Blankj/AndroidStandardDevelop
[AS常用开发插件]: http://www.jianshu.com/p/c76b0d8a642d
[Android Studio下对资源进行分包]: http://www.jianshu.com/p/8e893581b9c7
[Android开发之版本统一规范]: http://www.jianshu.com/p/db6ef4cfa5d1
[Android 流行框架查速表]: http://www.ctolib.com/cheatsheets-Android-ch.html
[Android开发人员不得不收集的代码]: https://github.com/Blankj/AndroidUtilCode
[Retrofit]: https://github.com/square/retrofit
[RxAndroid]: https://github.com/ReactiveX/RxAndroid
[OkHttp]: https://github.com/square/okhttp
[Glide]: https://github.com/bumptech/glide
[Fresco]: https://github.com/facebook/fresco
[Gson]: https://github.com/google/gson
[Fastjson]: https://github.com/alibaba/fastjson
[EventBus]: https://github.com/greenrobot/EventBus
[AndroidEventBus]: https://github.com/bboyfeiyu/AndroidEventBus
[GreenDao]: https://github.com/greenrobot/greenDAO
[Dagger2]: https://github.com/google/dagger
[Tinker]: https://github.com/Tencent/tinker
[Android包命名规范]: http://www.ayqy.net/blog/android%E5%8C%85%E5%91%BD%E5%90%8D%E8%A7%84%E8%8C%83/
[Android 开发最佳实践]: https://github.com/futurice/android-best-practices/blob/master/translations/Chinese/README.cn.md
[Android 编码规范]: http://www.jianshu.com/p/0a984f999592
[阿里巴巴Java开发手册]: https://102.alibaba.com/newsInfo.htm?newsId=6
[Google Java编程风格指南]: http://www.hawstein.com/posts/google-java-style.html
[小细节，大用途，35 个 Java 代码性能优化总结！]: http://www.jianshu.com/p/436943216526
