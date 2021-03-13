import P99._
import com.sun.tracing.Probe
import org.scalatest.funspec.AnyFunSpec

class P99Spec extends AnyFunSpec {
    val testList: List[Int] = List(1,1,2,3,5,8)

    /**
     * P01
     * scala> last(List(1, 1, 2, 3, 5, 8))
     * res0: Int = 8
     */
    describe("P01") {
        it("#last") {
            assert(Problems99.last(List(1,1,2,3,5,8)) == 8)
        }
        it("#last2") {
            assert(Problems99.last2(List(1,1,2,3,5,8)) == 8)
        }
    }

    /**
     * P02
     * scala> penultimate(List(1, 1, 2, 3, 5, 8))
     * res0: Int = 5
     */
    describe("P02") {
        it("#penultimate") {
            assert(Problems99.penultimate(List(1,1,2,3,5,8)) == 5)
        }
    }

    /**
     * P03
     * scala> nth(2, List(1, 1, 2, 3, 5, 8))
     * res0: Int = 2
     */
    describe("P03") {
        it("#nth") {
            assert(Problems99.nth(2, testList) == 2)
        }
        it("#nth2") {
            assert(Problems99.nth2(2, testList) == 2)
        }
    }

    /**
     * P04
     * scala> length(List(1, 1, 2, 3, 5, 8))
     * res0: Int = 6
     */
    describe("P04") {
        it("#length") {
            assert(Problems99.length(testList) == 6)
        }
    }

    /**
     * P05
     * scala> reverse(List(1, 1, 2, 3, 5, 8))
     * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
     */
    describe("P05") {
        it("#reverse") {
            assert(Problems99.reverse(testList) == List(8,5,3,2,1,1))
        }
        it("#reverse2") {
            assert(Problems99.reverse2(testList) == List(8,5,3,2,1,1))
        }
        it("#reverse3") {
            assert(Problems99.reverse3(testList) == List(8,5,3,2,1,1))
        }
    }

    /**
     * P06
     * scala> isPalindrome(List(1, 2, 3, 2, 1))
     * res0: Boolean = true
     */
      describe("P06") {
            it("#isPalindrome") {
              assert(Problems99.isPalindrome(List(1,2,3,2,1)))
            }
      }

    /**
     * P07
     * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
     * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
     */
    describe("P07") {
        it("#flatten") {
            assert(Problems99.flatten(List(List(1,1),2,List(3,List(5,8)))) == testList)
        }
    }

    /**
     * P08
     * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
     * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
     */
    describe("P08") {
        it("#compress") {
            assert(Problems99.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List('a, 'b, 'c, 'a, 'd, 'e))
        }

        it("#compress2") {
            assert(Problems99.compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List('a, 'b, 'c, 'a, 'd, 'e))
        }
    }

    /**
     * P09
     * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
     * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
     */
    describe("P09") {
        it("#pack") {
            assert(Problems99.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
              == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
        }

        it("#pack2") {
            assert(Problems99.pack2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
              == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
        }
    }

    /**
     * P10
     * scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
     * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
     */
    describe("P10") {
        it("#encode") {
          assert(Problems99.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
        }
    }

    /**
     * P11
     * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
     * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
     */
    describe("P11") {
        it("#encodeModified") {
            assert(Problems99.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
        }
    }

    /**
     * P12
     * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
     * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
     */
    describe("P12") {
        it("#decode") {
            assert(Problems99.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        }
    }

    /**
     * P13
     * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
     * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
     */
    describe("P13") {
        it("#encodeDirect") {
            assert(Problems99.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
        }
    }

    /**
     * P14
     * scala> duplicate(List('a, 'b, 'c, 'c, 'd))
     * res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
     */
    describe("P14") {
        it("#duplicate") {
            assert(Problems99.duplicate(List('a, 'b, 'c, 'c, 'd)) == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
        }
    }

    /**
     * P15
     * scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
     * res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
     */
    describe("P15") {
        it("#duplicateN") {
            assert(Problems99.duplicateN(3, List('a, 'b, 'c, 'c, 'd)) ==  List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
        }
    }

    /**
     * P16
     * scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
     * res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
     */
    describe("P16") {
        it("#drop") {
            assert(Problems99.drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
        }

        it("#drop2") {
            assert(Problems99.drop2(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
        }
    }

    /**
     * P17
     * scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
     * res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
     */
    describe("P17") {
        it("#split") {
            assert(Problems99.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
        }

        it("#split2") {
            assert(Problems99.split2(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
        }
    }

    /**
     * P18
     * scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
     * res0: List[Symbol] = List('d, 'e, 'f, 'g)
     */
    describe("P18") {
        it("#slice") {
            assert(Problems99.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g))
        }
    }

    /**
     * P19
     * scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
     * res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
     *
     * scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
     * res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
     */
    describe("P19") {
        it("#rotate") {
            assert(Problems99.rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
            assert(Problems99.rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
        }
    }

    /**
     * P20
     * scala> removeAt(1, List('a, 'b, 'c, 'd))
     * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
     */
    describe("P20") {
        it("removeAt") {
            assert(Problems99.removeAt(1, List('a, 'b, 'c, 'd)) == (List('a, 'c, 'd),'b))
        }
        it("removeAt2") {
            assert(Problems99.removeAt2(1, List('a, 'b, 'c, 'd)) == (List('a, 'c, 'd),'b))
        }
    }

    /**
     * P21
     * scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
     * res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
     */
    describe("P21") {
        it("#insertAt") {
            assert(Problems99.insertAt('new, 1, List('a, 'b, 'c, 'd)) == List('a, 'new, 'b, 'c, 'd))
        }
    }
}
