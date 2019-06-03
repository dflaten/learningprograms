 @;Testing Beggining Student Language and Racket
#lang racket
(define (mag x)
  (cond [ (> x 0) "positive"]
	[ (= x 0) "zero"]
	[ (else) "negative"]))
(display mag 2)
