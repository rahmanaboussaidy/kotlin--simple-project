class User(val username: String, val password: String) {
    fun isValid(): Boolean {
        return username.isNotEmpty() && password.length >= 6
    }
}
