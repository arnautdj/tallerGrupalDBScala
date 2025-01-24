package dao
import doobie._
import doobie.implicits._
import cats.effect.IO
import cats.implicits._
import model.Estudiante
import coneccionDB.datbase



object EstudiantesDAO {
  def insert(estudiante: Estudiante ): ConnectionIO[Int] = {
    sql"""
     INSERT INTO estudiantes (nombre, edad, calificacion, genero)
     VALUES (
       ${estudiante.nombre},
       ${estudiante.edad},
       ${estudiante.calificacion},
       ${estudiante.genero}
     )
   """.update.run
  }

  def insertAll(estudiante: List[Estudiante]): IO[List[Int]] = {
    datbase.transactor.use { xa =>
      estudiante.traverse(t => insert(t).transact(xa))
    }
  }

  def listAllEstudiante(): ConnectionIO[List[Estudiante]] =
    sql"SELECT nombre, edad, calificacion, genero FROM estudiantes"
      .query[Estudiante]
      .to[List]

}