import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

import java.security.MessageDigest
import javax.crypto.BadPaddingException


fun main() {

    val textoOriginal =  "Hola"
    var clave = "3"
    var textoCifrado = ""
    var salida = ""
    //var aux = Prueba("nombre", "contraseña", "1", "clave")
    var aux = Prueba("nombre", "prueba")
    aux.printMsg()

    println(clave)
    textoCifrado = cifrar(textoOriginal, clave)
    println(textoCifrado)
    salida = descifrar(textoCifrado, clave)
    print(salida)
}


private fun cifrar(textoEnString : String, llaveEnString : String) : String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, getKey(llaveEnString))
    val textCifrado = Base64.getEncoder().encodeToString(cipher.doFinal(textoEnString.toByteArray(Charsets.UTF_8)))
    return textCifrado
}

@Throws(BadPaddingException::class)
private fun descifrar(textoCifrrado : String, llaveEnString : String) : String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, getKey(llaveEnString));
    val textDescifrado = String(cipher.doFinal(Base64.getDecoder().decode(textoCifrrado)))
    return textDescifrado
}


private fun getKey(llaveEnString : String): SecretKeySpec {
    var llaveUtf8 = llaveEnString.toByteArray(Charsets.UTF_8)
    val sha = MessageDigest.getInstance("SHA-1")
    llaveUtf8 = sha.digest(llaveUtf8)
    llaveUtf8 = llaveUtf8.copyOf(16)
    return SecretKeySpec(llaveUtf8, "AES")
}