package services.interpreters

import cats.Monad
import models.external.HttpResponse
import services.HttpClientT

class HttpClienInterpreter[M[_] : Monad] extends HttpClientT[M]{
  override def get(id: String): M[HttpResponse] = {
    // a dummy response
    val response: M[HttpResponse] = Monad[M].pure(
      HttpResponse(s"$id", 200)
    )
    response
  }
}
