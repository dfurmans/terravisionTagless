package services.interpreters


import cats.implicits._
import cats.Monad
import models.internal.{LocationData, LocationId}
import services.{HttpClientT, LocationDataT}

class TerravisionLocationInterpreter[M[_] : Monad](
                                                    httpClient: HttpClientT[M]
                                                  ) extends LocationDataT[M]{
  override def retrieveDataForId(id: String): M[LocationData] = {
    val dataReturn: M[LocationData] = for {
      a <- httpClient.get("")
    } yield LocationData(LocationId(a.body))
    dataReturn
  }

}
