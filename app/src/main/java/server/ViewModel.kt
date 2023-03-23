package server

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class MyViewModel: ViewModel() {
    /**
     * 这是此 ViewModel 运行的所有协程所用的任务。
     * 终止这个任务将会终止此 ViewModel 开始的所有协程。
     */
    private val viewModelJob = SupervisorJob()

    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)
    override fun onCleared() { //不清楚的去百度一下viewmodel生命周期
        super.onCleared()
        viewModelJob.cancel()
    }

    //协程一共有几种调度器，是有对应区别的，如下：
/*
Dispatchers 决定协程在哪个线程或线程池上运行（启动和恢复）。最重要的选项有：
    Dispatchers.Defualt：被用来执行 CPU 密集型操作
    Dispatchers.Main：被我们用来访问主线程，例如在 Android、Swing 或者 JavaFX 上
    Dispatchers.Main.immediate：它和 Dispatchers.Main 运行在同一个线程上，但如果没有必要，它不会重新调度
    Dispatchers.IO：被用来执行一些阻塞线程的操作
    调用了 limitParallelism的 Dispatchers.IO 或者带有自定义线程池的 Dispatcher.IO：我们用来处理大量的阻塞调用
    调用了 limitParallelism 并设置为1的 Dispatchers.Default 或 Dispatchers.IO，或具有单个线程的自定义调度器：被用来修改共享状态
    Dispatchers.Unconfined：当我们不关心协程在哪个线程上被挂起时使用
*/
}