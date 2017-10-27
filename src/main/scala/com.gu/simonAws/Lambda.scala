package com.gu.simonAws

import io.circe.syntax._
import java.io._
import java.nio.charset.StandardCharsets.UTF_8

import com.typesafe.scalalogging.LazyLogging

import scala.io.Source

object Lambda extends LazyLogging {
  def handler(in: InputStream, out: OutputStream): Unit = {
    val received = Source.fromInputStream(in).mkString
    val response = APIResponse(200,  Map("Content-Type" -> "application/json"), received)
    //no spaces converts json to a string
    out.write(response.asJson.noSpaces.getBytes(UTF_8))
  }
}

