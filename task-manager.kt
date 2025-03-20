// TASK MANAGER SIMPLE APPLICATION
sealed class TaskStatus {
    object Pending : TaskStatus()
    object Completed : TaskStatus()
    class InProgress(val progress: Int) : TaskStatus()
}

data class Task(val title: String, val description: String, var status: TaskStatus)

fun Task.displayInfo() {
    val statusText = when (status) {
        is TaskStatus.Pending -> "Pending"
        is TaskStatus.Completed -> "Completed"
        is TaskStatus.InProgress -> "In Progress (${(status as TaskStatus.InProgress).progress}%)"
    }
    println("Task: $title\nDescription: $description\nStatus: $statusText")
}


class TaskManager {
    lateinit var tasks: MutableList<Task>

    
    val welcomeMessage: String by lazy {
        "Welcome to the Task Manager App!"
    }

    fun initializeTasks() {
        tasks = mutableListOf()
    }

    fun addTask(task: Task) {
        if (!::tasks.isInitialized) {
            println("Tasks not initialized. Initializing now...")
            initializeTasks()
        }
        tasks.add(task)
    }

    fun showAllTasks() {
        if (!::tasks.isInitialized || tasks.isEmpty()) {
            println("No tasks available.")
        } else {
            tasks.forEach { it.displayInfo() }
        }
    }
}

fun main() {
    val manager = TaskManager()

    println(manager.welcomeMessage)
    
    manager.addTask(
        Task(
            title = "Complete Kotlin Assignment",
            description = "Finish the task manager app.",
            status = TaskStatus.Pending
        )
    )

    manager.addTask(
        Task(
            title = "Prepare Presentation",
            description = "Create slides for Kotlin features.",
            status = TaskStatus.InProgress(progress = 50)
        )
    )
    
    println("\nAll Tasks:")
    manager.showAllTasks()
    
    val (title, description, status) = manager.tasks[0]
    println("\nFirst Task Details:")
    println("Title: $title\nDescription: $description\nStatus: $status")
}
