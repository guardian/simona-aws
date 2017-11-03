package com.gu.simonAws

import io.circe.syntax._
import io.circe.parser._
import java.io._
import java.nio.charset.StandardCharsets.UTF_8

import com.typesafe.scalalogging.LazyLogging

import scala.io.Source

object Lambda extends LazyLogging {
  def handler(in: InputStream, out: OutputStream): Unit = {
    val received = Source.fromInputStream(in).mkString("")
    val request = decode[APIRequest](received).toOption.map(x => x.number).getOrElse(0)

    val message = request match {
      case 0 => "You have sent a problem things"
      case n => "Thank you for your " + n.toString
    }

    //val body = received.asJson
    val response = APIResponse(200,  Map("Content-Type" -> "application/json"), message)
    //no spaces converts json to a string
    out.write(response.asJson.noSpaces.getBytes(UTF_8))
  }
}

