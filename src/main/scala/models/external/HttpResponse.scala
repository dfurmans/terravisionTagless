package models.external

// This is a service mode - could be weakly typed.
case class HttpResponse(body: String, responseStatus: Int)