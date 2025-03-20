// using function as a return type:
fun lambdaexpression(majira: String): () -> Unit {
       if (majira == "asubuhi") {
           return salamuYaAsubuhi
           } else {
           return salamuYaMchana
           }
    }

    val salamu: (String) -> ()->Unit  = { majira ->
        if(majira == "asubuhi")
            salamuYaAsubuhi
        else if (majira == "mchana")
            salamuYaMchana
        else
            salamuYaJioni
    }
    val salamuYaAsubuhi = {
        println("Habari za asubuhi")
    }
    val salamuYaMchana = {
        println("Habari za mchana")
    }
    val salamuYaJioni = {
        println("Habari za jioni")
    }

    fun main() {
        val salamuKutokanaNaMajira = salamu("asubuhi")
        salamuKutokanaNaMajira()
    }

//passing a function to another function as an argument

fun main(){
    var unga = "ngano"

    pika(unga, maandazi)
    pika(unga, chapati)
    pika(unga, keki)
}
fun pika(unga: String, pishi: (String)->Unit){
    pishi(unga);
}
val maandazi: (String)->Unit = {unga ->
    println("Tunapika maandazi ya $unga")
}
val chapati: (String)->Unit = {unga ->
    println("Tunapika chapazi za $unga")
}
val keki:( String)-> Unit = {unga ->
    println("Tunapika keki ya $unga")
}

//use function as a parameter:

var mtu = {
    println("mtu si nyau")
}

fun main() {
    val mtu =   mtu
    mtu()
}

repeat function:
repeat(5) {
	salimia()
}