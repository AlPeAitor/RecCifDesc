/*class Prueba (var nombre: String="", var contra: String){

    var idUsu= ""
    var claveCifrado = ""
    constructor(var nom: String, var con: String):this(nom){
        nombre = nom
        contra = con
        idUsu = nom.first() + nom.count().toString()
        claveCifrado = (nom.first().toInt()+nom.count()).toString()
    }
}*/

class Prueba(var nombre: String="") {
    var contra: String = "14"
    var idUsu = ""
    var claveCifrado = ""
    constructor (nombre: String, contra: String): this(nombre){
        this.contra = contra
        this.idUsu = nombre.first() + nombre.count().toString()
        this.claveCifrado = (nombre.first().toInt()+nombre.count()).toString()
    }
    fun printMsg(){
        println("Name is $nombre. Age is $contra. idUsu is $idUsu. claveCifrado si $claveCifrado");
    }
}