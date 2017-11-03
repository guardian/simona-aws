package com.gu.simonAws

import io.circe.Decoder
import io.circe.syntax._
import io.circe.generic.extras.semiauto._

case class APIInput(number: Int)
case class APIRequest(body: APIInput)

object APIRequest {
  implicit val APIRequestDecoder : Decoder[APIRequest] = deriveDecoder

}