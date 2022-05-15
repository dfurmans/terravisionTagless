package services

import services.interpreters._
import cats.data.EitherT

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

object Types {
  type FutEither[A] = EitherT[Future, Throwable, A]
}

object InterpreterInstances {
  import Types._
  import cats.implicits._
  // now it is the time to configure data types
  lazy val httpClientInterpreter : HttpClientT[FutEither] = new HttpClienInterpreter[FutEither]

  lazy val terravisionLocationInterpreter: LocationDataT[FutEither] =
    new TerravisionLocationInterpreter[FutEither](
      httpClientInterpreter
  )

}
