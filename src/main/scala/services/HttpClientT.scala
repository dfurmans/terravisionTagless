package services

import models.external.HttpResponse


trait HttpClientT[M[_]] {
  def get(id :String) : M[HttpResponse]
}