package programs

import cats.implicits._
import models.internal.{LocationData, LocationId}
import services.InterpreterInstances
import services.Types.FutEither

import scala.concurrent.ExecutionContext.Implicits.global

class ProgramInstances {

  lazy val render: LocationId => FutEither[LocationData] = RenderTerravisonProgram.renderTerrvisionLocation(
    InterpreterInstances.terravisionLocationInterpreter
  )
}
