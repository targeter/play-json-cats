package com.iravid.playjsoncats

import cats.kernel.instances.all._
import cats.laws.discipline._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline
import play.api.libs.json.{Format, Reads, Writes}

class FormatInstancesSpec extends AnyFunSuite with Discipline with ScalaCheckDrivenPropertyChecks with FormatInstances {
  import Arbitraries._

  checkAll("Format", InvariantTests[Format].invariant[String, String, String])
}

class ReadsInstancesSpec extends AnyFunSuite with Discipline with ScalaCheckDrivenPropertyChecks with ReadsInstances {
  import Arbitraries._

  checkAll("Reads", FunctorTests[Reads].functor[String, String, String])
  checkAll("Reads", ApplicativeTests[Reads].applicative[String, String, String])
  checkAll("Reads", MonadTests[Reads].monad[String, String, String])
}

class WritesInstancesSpec extends AnyFunSuite with Discipline with ScalaCheckDrivenPropertyChecks with WritesInstances {
  import Arbitraries._

  checkAll("Reads", ContravariantTests[Writes].contravariant[String, String, String])
}
