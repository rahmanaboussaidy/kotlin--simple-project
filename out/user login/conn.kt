class MainActivity : AppCompatActivity() {
    private lateinit var loginController: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginController = LoginController(this)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()
            loginController.handleLogin(username, password)
        }
    }

    fun showMessage(message: String) {
        findViewById<TextView>(R.id.tvMessage).text = message
    }
}
