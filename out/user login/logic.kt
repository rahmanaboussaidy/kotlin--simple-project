class LoginController(val view: MainActivity) {
    fun handleLogin(username: String, password: String) {
        val user = User(username, password)
        if (user.isValid()) {
            view.showMessage("Login Successful!")
        } else {
            view.showMessage("Invalid Username or Password")
        }
    }
}
