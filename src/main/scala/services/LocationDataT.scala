package services

import models.internal.LocationData

trait LocationDataT[M[_]] {
  def retrieveDataForId(id: String): M[LocationData]
}
