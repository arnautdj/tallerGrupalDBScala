import cats.effect.{IO, IOApp}
import kantan.csv._
import kantan.csv.ops._
import kantan.csv.generic._

import cats.effect.unsafe.implicits.global

import java.io.File
import dao.EstudiantesDAO
import doobie.ConnectionIO
import model.Estudiante


// Extiende de IOApp.Simple para manejar efectos IO y recursos de forma segura
object Main extends IOApp.Simple {

  val transactor = coneccionDB.datbase.transactor.allocated.unsafeRunSync()


  val path2DataFile2 = "src/main/resources/data/estudiantes.csv"

  val dataSource = new File(path2DataFile2)
    .readCsv[List, Estudiante](rfc.withHeader.withCellSeparator(','))

  val estudiante = dataSource.collect {
    case Right(estudiante) => estudiante
  }

  /**
   * Punto de entrada principal de la aplicación.
   * Lee temperaturas desde CSV, las inserta en la base de datos,
   * e imprime el número de registros insertados.
   *
   * @return IO[Unit] que representa la secuencia de operaciones
   */

  def run: IO[Unit] =
    EstudiantesDAO.insertAll(estudiante)
      .flatMap(result => IO.println(s"Registros insertados: ${result.size}"))


  print(dao.EstudiantesDAO.listAllEstudiante())


}