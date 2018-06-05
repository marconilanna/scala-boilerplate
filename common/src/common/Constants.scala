/*
 * Copyright 2011-2018 Marconi Lanna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package project.common

object Constants extends Constants

trait Constants {
  /**
   * Pre-defined constants to exclude a specific piece of code from one or more Scapegoat checks
   * using the `SuppressWarnings` annotation.
   *
   * @example {{{
   * @SuppressWarnings(Array(Goats.TryGet))
   * }}}
   */
  object Goats {
    final val ArrayEquals = "ArrayEquals" // scalastyle:ignore multiple.string.literals
    final val ArraysInFormat = "ArraysInFormat"
    final val ArraysToString = "ArraysToString"
    final val AvoidOperatorOverload = "AvoidOperatorOverload"
    final val AvoidSizeEqualsZero = "AvoidSizeEqualsZero"
    final val AvoidSizeNotEqualsZero = "AvoidSizeNotEqualsZero"
    final val AvoidToMinusOne = "AvoidToMinusOne"
    final val AsInstanceOf = "AsInstanceOf" // scalastyle:ignore multiple.string.literals
    final val BigDecimalDoubleConstructor = "BigDecimalDoubleConstructor"
    final val BigDecimalScaleWithoutRoundingMode = "BigDecimalScaleWithoutRoundingMode"
    final val BoundedByFinalType = "BoundedByFinalType"
    final val BrokenOddness = "BrokenOddness"
    final val CatchNpe = "CatchNpe"
    final val CatchException = "CatchException"
    final val CatchFatal = "CatchFatal"
    final val CatchThrowable = "CatchThrowable"
    final val ClassNames = "ClassNames"
    final val CollectionIndexOnNonIndexedSeq = "CollectionIndexOnNonIndexedSeq"
    final val CollectionNamingConfusion = "CollectionNamingConfusion"
    final val CollectionNegativeIndex = "CollectionNegativeIndex"
    final val CollectionPromotionToAny = "CollectionPromotionToAny"
    final val ComparingFloatingPointTypes = "ComparingFloatingPointTypes"
    final val ComparingUnrelatedTypes = "ComparingUnrelatedTypes"
    final val ComparisonToEmptyList = "ComparisonToEmptyList"
    final val ComparisonToEmptySet = "ComparisonToEmptySet"
    final val ComparisonWithSelf = "ComparisonWithSelf"
    final val ConstantIf = "ConstantIf"
    final val DivideByOne = "DivideByOne"
    final val DoubleNegation = "DoubleNegation"
    final val DuplicateImport = "DuplicateImport"
    final val DuplicateMapKey = "DuplicateMapKey"
    final val DuplicateSetValue = "DuplicateSetValue"
    final val EitherGet = "EitherGet"
    final val EmptyCaseClass = "EmptyCaseClass"
    final val EmptyFor = "EmptyFor"
    final val EmptyIfBlock = "EmptyIfBlock"
    final val EmptyInterpolatedString = "EmptyInterpolatedString"
    final val EmptyMethod = "EmptyMethod"
    final val EmptySynchronizedBlock = "EmptySynchronizedBlock"
    final val EmptyTryBlock = "EmptyTryBlock"
    final val EmptyWhileBlock = "EmptyWhileBlock"
    final val ExistsSimplifableToContains = "ExistsSimplifableToContains"
    final val FilterDotHead = "FilterDotHead"
    final val FilterDotHeadOption = "FilterDotHeadOption"
    final val FilterDotIsEmpty = "FilterDotIsEmpty"
    final val FilterOptionAndGet = "FilterOptionAndGet"
    final val FilterDotSize = "FilterDotSize"
    final val FinalizerWithoutSuper = "FinalizerWithoutSuper"
    final val FinalModifierOnCaseClass = "FinalModifierOnCaseClass"
    final val FindDotIsDefined = "FindDotIsDefined"
    final val FindAndNotEqualsNoneReplaceWithExists = "FindAndNotEqualsNoneReplaceWithExists"
    final val IllegalFormatString = "IllegalFormatString"
    final val IncorrectlyNamedExceptions = "IncorrectlyNamedExceptions"
    final val IncorrectNumberOfArgsToFormat = "IncorrectNumberOfArgsToFormat"
    final val InvalidRegex = "InvalidRegex"
    final val ImpossibleOptionSizeCondition = "ImpossibleOptionSizeCondition"
    final val IsInstanceOf = "IsInstanceOf" // scalastyle:ignore multiple.string.literals
    final val JavaConversionsUse = "JavaConversionsUse"
    final val ListAppend = "ListAppend"
    final val ListSize = "ListSize"
    final val LooksLikeInterpolatedString = "LooksLikeInterpolatedString"
    final val LonelySealedTrait = "LonelySealedTrait"
    final val MapGetAndGetOrElse = "MapGetAndGetOrElse"
    final val MaxParameters = "MaxParameters"
    final val MethodNames = "MethodNames"
    final val MethodReturningAny = "MethodReturningAny"
    final val ModOne = "ModOne"
    final val NanComparison = "NanComparison"
    final val NegationIsEmpty = "NegationIsEmpty"
    final val NegationNonEmpty = "NegationNonEmpty"
    final val NoOpOverride = "NoOpOverride"
    final val NullAssignment = "NullAssignment"
    final val NullParameter = "NullParameter"
    final val ObjectNames = "ObjectNames"
    final val OptionGet = "OptionGet"
    final val OptionSize = "OptionSize"
    final val ParameterlessMethodReturnsUnit = "ParameterlessMethodReturnsUnit"
    final val PartialFunctionInsteadOfMatch = "PartialFunctionInsteadOfMatch"
    final val PointlessTypeBounds = "PointlessTypeBounds"
    final val PreferSeqEmpty = "PreferSeqEmpty"
    final val PreferSetEmpty = "PreferSetEmpty"
    final val ProductWithSerializableInferred = "ProductWithSerializableInferred"
    final val PublicFinalizer = "PublicFinalizer"
    final val RedundantFinalizer = "RedundantFinalizer"
    final val RedundantFinalModifierOnMethod = "RedundantFinalModifierOnMethod"
    final val RedundantFinalModifierOnVar = "RedundantFinalModifierOnVar"
    final val RepeatedCaseBody = "RepeatedCaseBody"
    final val ReverseTailReverse = "ReverseTailReverse"
    final val ReverseTakeReverse = "ReverseTakeReverse"
    final val ReverseFunc = "ReverseFunc"
    final val SimplifyBooleanExpression = "SimplifyBooleanExpression"
    final val StripMarginOnRegex = "StripMarginOnRegex"
    final val SubstringZero = "SubstringZero"
    final val SuspiciousMatchOnClassObject = "SuspiciousMatchOnClassObject"
    final val SwallowedException = "SwallowedException"
    final val SwapSortFilter = "SwapSortFilter"
    final val TraversableHead = "TraversableHead"
    final val TryGet = "TryGet"
    final val TypeShadowing = "TypeShadowing"
    final val UnnecessaryIf = "UnnecessaryIf"
    final val UnnecessaryReturnUse = "UnnecessaryReturnUse"
    final val UnnecessaryToInt = "UnnecessaryToInt"
    final val UnnecessaryToString = "UnnecessaryToString"
    final val UnreachableCatch = "UnreachableCatch"
    final val UnsafeContains = "UnsafeContains"
    final val UnusedMethodParameter = "UnusedMethodParameter"
    final val UseCbrt = "UseCbrt"
    final val UseExpM1 = "UseExpM1"
    final val UseLog10 = "UseLog10"
    final val UseLog1P = "UseLog1P"
    final val UseSqrt = "UseSqrt"
    final val VarClosure = "VarClosure"
    final val VarCouldBeVal = "VarCouldBeVal"
    final val WhileTrue = "WhileTrue"
    final val ZeroNumerator = "ZeroNumerator"
  }

  /**
   * Pre-defined constants to exclude a specific piece of code from one or more WartRemover checks
   * using the `SuppressWarnings` annotation.
   *
   * @example {{{
   * @SuppressWarnings(Array(Warts.Any))
   * }}}
   */
  object Warts {
    private final val Wart = "org.wartremover.warts."
    private final val Contrib = "org.wartremover.contrib.warts."
    private final val Extra = "org.danielnixon.extrawarts."

    final val Any = Wart + "Any"
    final val AnyVal = Wart + "AnyVal"
    final val ArrayEquals = Wart + "ArrayEquals"
    final val AsInstanceOf = Wart + "AsInstanceOf"
    final val DefaultArguments = Wart + "DefaultArguments"
    final val EitherProjectionPartial = Wart + "EitherProjectionPartial"
    final val Enumeration = Wart + "Enumeration"
    final val Equals = Wart + "Equals"
    final val ExplicitImplicitTypes = Wart + "ExplicitImplicitTypes"
    final val FinalCaseClass = Wart + "FinalCaseClass"
    final val FinalVal = Wart + "FinalVal"
    final val ImplicitConversion = Wart + "ImplicitConversion"
    final val ImplicitParameter = Wart + "ImplicitParameter"
    final val IsInstanceOf = Wart + "IsInstanceOf"
    final val JavaConversions = Wart + "JavaConversions"
    final val JavaSerializable = Wart + "JavaSerializable"
    final val LeakingSealed = Wart + "LeakingSealed"
    final val MutableDataStructures = Wart + "MutableDataStructures"
    final val NonUnitStatements = Wart + "NonUnitStatements"
    final val Nothing = Wart + "Nothing"
    final val Null = Wart + "Null"
    final val Option2Iterable = Wart + "Option2Iterable"
    final val OptionPartial = Wart + "OptionPartial"
    final val Overloading = Wart + "Overloading"
    final val Product = Wart + "Product"
    final val PublicInference = Wart + "PublicInference"
    final val Recursion = Wart + "Recursion"
    final val Return = Wart + "Return"
    final val Serializable = Wart + "Serializable"
    final val StringPlusAny = Wart + "StringPlusAny"
    final val Throw = Wart + "Throw"
    final val ToString = Wart + "ToString"
    final val TraversableOps = Wart + "TraversableOps"
    final val TryPartial = Wart + "TryPartial"
    final val Var = Wart + "Var"
    final val While = Wart + "While"

    final val Apply = Contrib + "Apply"
    final val ExposedTuples = Contrib + "ExposedTuples"
    final val OldTime = Contrib + "OldTime"
    final val SealedCaseClass = Contrib + "SealedCaseClass"
    final val SomeApply = Contrib + "SomeApply"
    final val SymbolicName = Contrib + "SymbolicName"
    final val UnsafeInheritance = Contrib + "UnsafeInheritance"

    final val EnumerationPartial = Extra + "EnumerationPartial"
    final val FutureObject = Extra + "FutureObject"
    final val GenMapLikePartial = Extra + "GenMapLikePartial"
    final val GenTraversableLikeOps = Extra + "GenTraversableLikeOps"
    final val GenTraversableOnceOps = Extra + "GenTraversableOnceOps"
    final val ScalaGlobalExecutionContext = Extra + "ScalaGlobalExecutionContext"
    final val StringOpsPartial = Extra + "StringOpsPartial"
    final val ThrowablePartial = Extra + "ThrowablePartial"
    final val TraversableOnceOps = Extra + "TraversableOnceOps"
  }
}
