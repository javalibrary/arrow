package arrow.validation.refinedTypes.numeric

import arrow.core.extensions.order
import arrow.test.UnitSpec
import arrow.test.generators.genGreaterEqual
import arrow.test.generators.genLessThan
import arrow.validation.refinedTypes.numeric.validated.nonNegative.nonNegative
import io.kotlintest.properties.forAll
import io.kotlintest.runner.junit4.KotlinTestRunner
import org.junit.runner.RunWith

@RunWith(KotlinTestRunner::class)
class NonNegativeTest : UnitSpec() {
  init {

    "Should create NonNegative for every x >= 0" {
      forAll(genGreaterEqual(0)) { x: Int ->
        x.nonNegative(Int.order()).isValid
      }
    }

    "Should not create NonNegative for any x < 0" {
      forAll(genLessThan(0)) { x: Int ->
        x.nonNegative(Int.order()).isInvalid
      }
    }

  }
}