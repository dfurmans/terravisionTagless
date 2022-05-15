package models.internal

// Internal model is a Business model - dur to that strong and well typed
case class LocationId(id: String)
case class LocationData(
                       locationId: LocationId
                       )
