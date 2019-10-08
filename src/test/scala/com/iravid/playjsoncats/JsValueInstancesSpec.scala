package com.iravid.playjsoncats

import cats.kernel.laws.discipline.MonoidTests
import cats.{Monoid, Semigroup}
import com.iravid.playjsoncats.JsArrayInstances._
import com.iravid.playjsoncats.JsObjectInstances._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline
import play.api.libs.json._

class JsValueInstancesSpec extends AnyFunSuite with Discipline with ScalaCheckDrivenPropertyChecks {
  import Arbitraries._

  checkAll("JsObject", MonoidTests[JsObject].monoid)
  checkAll("JsArray", MonoidTests[JsArray].monoid)

  {
    Monoid[JsObject]
    Semigroup[JsObject]
    Monoid[JsArray]
    Semigroup[JsArray]
  }
}
