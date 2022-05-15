package services.interpreters

import cats.Monad
import cats.implicits._
import models.external.HttpResponse
import services.HttpClientT

class HttpClienInterpreter[M[_] : Monad] extends HttpClientT[M]{
  override def get(id: String): M[HttpResponse] = {
    val response: M[HttpResponse] = Monad[M].pure(
      HttpResponse("", 200)
    )
    response
  }
}
