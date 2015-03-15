package dev.chimera.innovation

import org.scalamock.scalatest.MockFactory
import org.scalatest._

/**
 * Created by jin on 3/14/15.
 */
abstract class UnitSpec extends FlatSpec with Matchers with
OptionValues with Inside with Inspectors with MockFactory