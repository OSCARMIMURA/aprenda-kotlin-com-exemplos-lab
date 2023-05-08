// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

//Além das aulas da Dio, foi usado esse video como referência https://www.youtube.com/watch?v=VeoFtAESnlU

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
enum class Acesso { DEFAULT, PROFESSOR, ALUNO }

open class Usuario( val email: String){
    
    open var senha: String = "123"
    open var acesso:Acesso = Acesso.DEFAULT
    open var nome:String = ""
    open fun print(){
        println ("INFORMAÇÕES DE USUARIO ${this.nome}")
        println ("Email : ${this.email} Acesso: ${this.acesso} senha: ${this.senha} \n")
    }
    
}
                 

class Aluno ( email: String ) : Usuario(email= email){
    open var nivel:Nivel = Nivel.BASICO
    override var acesso:Acesso = Acesso.ALUNO
    override fun print(){
        println ("INFORMAÇÕES DE ALUNO ${super.nome}")
         println ("Email : ${super.email} Acesso: ${this.acesso} Nivel: ${this.nivel} senha : ${super.senha}  \n")
    }
}

class Professor ( email: String ) : Usuario(email= email){
     override var acesso:Acesso = Acesso.PROFESSOR
    override fun print(){
        println ("INFORMAÇÕES DE INSTRUTOR(A) ${super.nome}")
         println ("Email : ${super.email} Acesso: ${this.acesso}  senha : ${super.senha}   \n")
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel:Nivel, var professor:Professor ){
     open fun print(){
        println ("Criacao do conteudo ${this.nome}")
        println ("nome : ${this.nome} duracao: ${this.duracao} nivel: ${this.nivel} instrutor(a) ${this.professor.nome} \n")
    
     }
     
      open fun printF(){
         print ("nome : ${this.nome} duracao: ${this.duracao} nivel: ${this.nivel} instrutor(a) ${this.professor.nome} \n")
    
     }
 }

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(aluno: Aluno) {
        //print("Passei por aqui")
        inscritos.add(aluno).also{
        println("Parabens, ${aluno.nome}!! Voce esta matriculado em nossa formacao ${this.nome}")
    	}
    }
    
      fun print(){
        println ("formacao : ${this.nome}  ")
       for (a in conteudos)
          println (a.printF())    
            println ("--------------------------------------------------------------  ")
		}
  
    				
       // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    
}

fun main() {
   // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    var u1=Usuario( "maria@email")
    u1.nome = "Maria Selena"
    u1.print()
    println ("--------------------------------------------------------------  ")
    val a2=Aluno( "jose@email")
    a2.nome = "jose Silva"
    println ("INFORMAÇÕES INICIAIS DO ALUNO ${a2.nome}")
    a2.print()
    println ("ALTERANDO A SENHA DO ALUNO ${a2.nome}")
    a2.senha = "batata"
    a2.print()
     println ("--------------------------------------------------------------  ")
    val p1 = Professor("Pardal@email")
    val p2 = Professor("Helena@email")
    p1.nome = "Professor Pardal"
    p2.nome = "Professora Helena"
    p1.print()
    p2.print()
   	 println ("--------------------------------------------------------------  ")
   val c1 = ConteudoEducacional("Java", 60, Nivel.BASICO,p1)
   val c2 = ConteudoEducacional("Sql", 60, Nivel.INTERMEDIARIO,p2)
   c1.print()
    c2.print()
    println ("--------------------------------------------------------------  ")
   val conteudos:MutableList<ConteudoEducacional> =mutableListOf(c1,c2)
   val f1 = Formacao("Spring Boot", conteudos)
   f1.print()
   
   println ("matriculando o aluno ${a2.nome}")
   f1.matricular (a2)
     