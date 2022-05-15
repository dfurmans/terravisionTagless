package programs

import cats.implicits._
import cats.{Applicative, MonadError}
import models.internal.{LocationData, LocationId}
import services.LocationDataT

object RenderTerravisonProgram {

  def renderTerrvisionLocation[M[_] :Applicative](
                                                    terravisionLocationInterpreter: LocationDataT[M]
                                                 )
                                                 (
                                                   locationId: LocationId
                                                 )
                                                 (
                                                   implicit A: Applicative[M],
                                                   ME: MonadError[M, Throwable]
                                                 ) : M[LocationData] ={
    val maybeAData = for {
      aTerra <- terravisionLocationInterpreter.retrieveDataForId(locationId.id)
    } yield aTerra

    ME.recoverWith(maybeAData) {
      case error => {}
        s"error $error" // this should be LOGGER issue
        A.pure(LocationData(LocationId(""))) // return a Monoid
    }
  }

}
