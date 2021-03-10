package org.seeingpixels.adoptionimpact.common.tuples

infix fun <A, B, C> Pair<A, B>.to(third: C): Triple<A, B, C> = Triple(first, second, third)