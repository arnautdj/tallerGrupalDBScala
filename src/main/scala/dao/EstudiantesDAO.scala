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
     INSERT INTO temperaturas (dia, temperatura_manana, temperatura_tarde)
     VALUES (
       ${estudiante.nombre},
       ${estudiante.edad},
       ${estudiante.calificacion}
       ${estudiante.genero}
     )
   """.update.run
  }

  def insertAll(estudiante: List[Estudiante]): IO[List[Int]] = {
    datbase.transactor.use { xa =>
      estudiante.traverse(t => insert(t).transact(xa))
    }
  }
}