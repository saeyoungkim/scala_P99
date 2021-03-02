import org.scalatest._
import P99._

class P99Spec extends FunSuite with DiagrammedAssertions {
    
    test("Hello should start with H") {
        assert((Problems99.hello).startsWith("H"))
    }
}