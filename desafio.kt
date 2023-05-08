// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
enum class Acesso { DEFAULT, PROFESSOR, ALUNO }

open class Usuario( val email: String){
    
    open var senha: String = "123"
    open var acesso:Acesso = Acesso.DEFAULT
    open var nome:String = ""
    open fun print(){
        println ("Email : ${this.email} Acesso: ${this.acesso} senha: ${this.senha} ")
    }
    
}
                 

class Aluno ( email: String ) : Usuario(email= email){
    open var nivel:Nivel = Nivel.BASICO
    override var acesso:Acesso = Acesso.ALUNO
    override fun print(){
         println ("Email : ${super.email} Acesso: ${this.acesso} Nivel: ${this.nivel} senha : ${super.senha}")
    }
}

class Professor ( email: String ) : Usuario(email= email){
     override var acesso:Acesso = Acesso.PROFESSOR
    override fun print(){
         println ("Email : ${super.email} Acesso: ${this.acesso}  senha : ${super.senha} ")
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel:Nivel, var professor:Professor ){
     open fun print(){
        println ("nome : ${this.nome} duracao: ${this.duracao} nivel: ${this.nivel} professor ${this.professor.email}")
    }
 }

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(aluno: Aluno) {
        inscritos.add(aluno).also{
        println("aluno matriculado")
    	}
    }
    
      fun print(){
        println ("nome : ${this.nome} ")
       println (conteudos)
		}
    				
       // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    
}

fun main() {
   // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val a1=Usuario( "jose")
    a1.print()
      val a2=Aluno( "jose")
    a2.print()
    a2.senha = "batata"
    a2.print()
    val a3 = Professor("jose")
    val a4 = Professor("maria")
    a3.print()
    a4.print()
   	a1.print()
   val c1 = ConteudoEducacional("Java", 60, Nivel.BASICO,a3)
   val c2 = ConteudoEducacional("Java", 60, Nivel.INTERMEDIARIO,a3)
   c1.print()
   
   val conteudos:MutableList<ConteudoEducacional> =mutableListOf(c1,c2)
   val f1 = Formacao("Spring Boot", conteudos)
   f1.print()
     
     //val conteudos: MutableList<Int> = mutableListOf(1, 2, 3)        // 1
//val sudoers: List<Int> = systemUsers                              // 2

        
    
}