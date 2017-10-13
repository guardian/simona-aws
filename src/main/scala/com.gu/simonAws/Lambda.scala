package com.gu.simonAws

import com.typesafe.scalalogging.LazyLogging

object Lambda extends LazyLogging {
  def handler(): String = {
    "hello world"
  }
}
