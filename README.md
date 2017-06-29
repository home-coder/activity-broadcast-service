# activity-broadcast-service
活动，广播，服务的综合应用，intent方式多种，广播形式多种，服务又分本地和远程。

1.自定义MVC架构，主入口MainActivity, 控制Controller, 建立一个UI

考虑如果是不同类型的布局，如何来通过controller去控制显示，当然就是使用接口了，让不同的布局对接一个接口
下面实现controller的控制
1.1 一个Activity，多个布局
1.2 两个Activity，多个布局,实现点击湖北，广东，台湾会切换不同的视频源,并在第二个Activity活动中进行播放。
1.3 如果有耗时操作，在UI的MVC中的View里面进行线程操作，比如从Controller--dispatchmessage, UI--processmessage--handler.send..--hander，然后回到主线程刷新UI
1.4 优化Case， 一个是Case该不该放到Bean类里面，另外一个是Case中不同的变量要进行分类。
1.5 Android中，我们在线程之间通信传递通常采用Android的消息机制，而这机制传递的正是Message。
    通常，我们使用Message.obtain()和Handler.obtainMessage()从Message Pool中获取Message，避免直接构造Message。


2.Activity启动service，service通知controller，controller更新UI，比如将地点listview更新



3.通知的方式用getNotificationManager还是Broadcast，或者我说错了

4.另起动一个AIDL方式的远端服务，, activity获取代理do something

5.添加数据存储功能，使用sharepreference， LitePal数据库， 不考虑SQLite老数据库

6.手动写一个自定义的地点列表的xml文件

7.实现xml数据解析，并更新原始listview

8.监听一个接口如何做接口回调，网上有这方面的讲解，下面的代码是永新视博的一个使用案例
public interface OnMonitorListener{
	void onMonitor(int monitorType,Object message);
}

9.使用RecycleView实现横向的view

