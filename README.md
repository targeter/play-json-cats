[![Build Status](https://travis-ci.org/iravid/play-json-cats.svg?branch=master)](https://travis-ci.org/iravid/play-json-cats)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.iravid/play-json-cats_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.iravid/play-json-cats_2.12)

# play-json-cats

`cats` typeclass instances for the `play-json` library.

## Adding as a dependency to your project

```scala
libraryDependencies += "com.iravid" %% "play-json-cats" % 1.1.0
```

`play-json-cats` is cross-published for Scala 2.11 and 2.12.

## Usage

```scala
import cats.implicits._
import com.iravid.playjsoncats.implicits._
import play.api.libs.json._

case class Person(name: String, i: Int)

val rn: Reads[String] = Reads(j => (j \ "name").validate[String])
val ri: Reads[Int] = Reads(j => (j \ "i").validate[Int])
val rp: Reads[Person] = (rn, rp).mapN(Person)

val res: JsResult[Person] = rp.reads(Json.parse("""
  { "name": "iravid", "i": 42 }
"""))
```

## Provided instances

| `play-json` type | provided instances                            |
|------------------|-----------------------------------------------|
| `Reads[A]`       | `Functor`, `Applicative`, `Monad`             |
| `Writes[A]`      | `Contravariant`                               |
| `Format[A]`      | `Invariant`                                   |
| `JsResult[A]`    | `Functor`, `Applicative`, `ApplicativeError`  |
|                  | `Monad`, `MonadError`, `Traverse`,            |
|                  | `Monoid` (for `A: Monoid`)                    |
