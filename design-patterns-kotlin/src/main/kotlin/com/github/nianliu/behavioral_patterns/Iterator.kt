package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Test

data class Task(val age: Int, val priority: Int, val runnable: () -> Unit)

interface TaskQueueIterator {
    fun getNext(): Task
    fun hasNext(): Boolean
}

interface TaskQueue {
    fun createFirstInFirstServeIterator(): TaskQueueIterator
    fun createPriorityFirstIterator(): TaskQueueIterator
}

class FirstInFirstServeIterator(tasks: List<Task>) : TaskQueueIterator {
    private val tasks = tasks.sortedByDescending { it.age }
    private var index = 0

    override fun getNext(): Task = tasks[index++]
    override fun hasNext(): Boolean = index < tasks.size
}

class PriorityFirstIterator(tasks: List<Task>) : TaskQueueIterator {
    private val tasks = tasks.sortedBy { it.priority }
    private var index = 0

    override fun getNext(): Task = tasks[index++]
    override fun hasNext(): Boolean = index < tasks.size
}

class MyTaskQueue(private val tasks: List<Task>) : TaskQueue {
    override fun createFirstInFirstServeIterator() = FirstInFirstServeIterator(tasks)
    override fun createPriorityFirstIterator() = PriorityFirstIterator(tasks)
}

class TaskExecutor(private val taskQueue: TaskQueue) {
    fun executeByFIFO() {
        val iterator = taskQueue.createFirstInFirstServeIterator()
        while (iterator.hasNext()) {
            iterator.getNext().runnable.invoke()
        }
    }

    fun executeByPriority() {
        val iterator = taskQueue.createPriorityFirstIterator()
        while (iterator.hasNext()) {
            iterator.getNext().runnable.invoke()
        }
    }
}

class Iterator {
    @Test
    fun demo() {
        val taskQueue = MyTaskQueue(listOf(
            Task(1, 1) { println("This is a young task with high priority.") }
            , Task(2, 2) { println("This is a medium task with medium priority.") }
            , Task(3, 3) { println("This is an old task with low priority.") }
        ))

        TaskExecutor(taskQueue)
            .apply { executeByFIFO() }
            .apply { executeByPriority() }
    }
}