package example

import cats.data.EitherT
import models.internal.{LocationData, LocationId}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import programs.ProgramInstances
import services.Types.FutEither
import scala.concurrent.ExecutionContext.global

import scala.concurrent.Future

class HelloSpec extends AnyFlatSpec with Matchers {
  val programInstances = new ProgramInstances

  "TerraVision render" should "render location via Interpreter" in {
    val renderInstance: LocationId => FutEither[LocationData] = programInstances.render
    val aLocationToRender = LocationId("1")
    val asyncComputationRepresentation: FutEither[LocationData] = renderInstance(aLocationToRender)

    val wtf = asyncComputationRepresentation match {
      // the problem of may pattern matching embedded cases
      case EitherT(maybeComputed) =>
        val rr = maybeComputed.value
        s"Rendered value is ${rr}"
    }

    println(
      s"""
        | ${asyncComputationRepresentation}
        |""".stripMargin)
  }

  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "hello"
  }
}
