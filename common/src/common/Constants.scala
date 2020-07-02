/*
 * Copyright 2011-2020 Marconi Lanna
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

// $COVERAGE-OFF$
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
    // http://github.com/sksamuel/scapegoat
    final val ArrayEquals = "ArrayEquals"
    final val ArraysInFormat = "ArraysInFormat"
    final val ArraysToString = "ArraysToString"
    final val AsInstanceOf = "AsInstanceOf"
    final val AvoidOperatorOverload = "AvoidOperatorOverload"
    final val AvoidSizeEqualsZero = "AvoidSizeEqualsZero"
    final val AvoidSizeNotEqualsZero = "AvoidSizeNotEqualsZero"
    final val AvoidToMinusOne = "AvoidToMinusOne"
    final val BigDecimalDoubleConstructor = "BigDecimalDoubleConstructor"
    final val BigDecimalScaleWithoutRoundingMode = "BigDecimalScaleWithoutRoundingMode"
    final val BoundedByFinalType = "BoundedByFinalType"
    final val BrokenOddness = "BrokenOddness"
    final val CatchException = "CatchException"
    final val CatchFatal = "CatchFatal"
    final val CatchNpe = "CatchNpe"
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
    final val ExistsSimplifiableToContains = "ExistsSimplifiableToContains"
    final val FilterDotHead = "FilterDotHead"
    final val FilterDotHeadOption = "FilterDotHeadOption"
    final val FilterDotIsEmpty = "FilterDotIsEmpty"
    final val FilterDotSize = "FilterDotSize"
    final val FilterOptionAndGet = "FilterOptionAndGet"
    final val FinalModifierOnCaseClass = "FinalModifierOnCaseClass"
    final val FinalizerWithoutSuper = "FinalizerWithoutSuper"
    final val FindAndNotEqualsNoneReplaceWithExists = "FindAndNotEqualsNoneReplaceWithExists"
    final val FindDotIsDefined = "FindDotIsDefined"
    final val IllegalFormatString = "IllegalFormatString"
    final val ImpossibleOptionSizeCondition = "ImpossibleOptionSizeCondition"
    final val IncorrectNumberOfArgsToFormat = "IncorrectNumberOfArgsToFormat"
    final val IncorrectlyNamedExceptions = "IncorrectlyNamedExceptions"
    final val InvalidRegex = "InvalidRegex"
    final val IsInstanceOf = "IsInstanceOf"
    final val JavaConversionsUse = "JavaConversionsUse"
    final val ListAppend = "ListAppend"
    final val ListSize = "ListSize"
    final val LonelySealedTrait = "LonelySealedTrait"
    final val LooksLikeInterpolatedString = "LooksLikeInterpolatedString"
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
    final val PreferMapEmpty = "PreferMapEmpty"
    final val PreferSeqEmpty = "PreferSeqEmpty"
    final val PreferSetEmpty = "PreferSetEmpty"
    final val ProductWithSerializableInferred = "ProductWithSerializableInferred"
    final val PublicFinalizer = "PublicFinalizer"
    final val RedundantFinalModifierOnMethod = "RedundantFinalModifierOnMethod"
    final val RedundantFinalModifierOnVar = "RedundantFinalModifierOnVar"
    final val RedundantFinalizer = "RedundantFinalizer"
    final val RepeatedCaseBody = "RepeatedCaseBody"
    final val RepeatedIfElseBody = "RepeatedIfElseBody"
    final val ReverseFunc = "ReverseFunc"
    final val ReverseTailReverse = "ReverseTailReverse"
    final val ReverseTakeReverse = "ReverseTakeReverse"
    final val SimplifyBooleanExpression = "SimplifyBooleanExpression"
    final val StripMarginOnRegex = "StripMarginOnRegex"
    final val SubstringZero = "SubstringZero"
    final val SuspiciousMatchOnClassObject = "SuspiciousMatchOnClassObject"
    final val SwallowedException = "SwallowedException"
    final val SwapSortFilter = "SwapSortFilter"
    final val TryGet = "TryGet"
    final val TypeShadowing = "TypeShadowing"
    final val UnnecessaryConversion = "UnnecessaryConversion"
    final val UnnecessaryIf = "UnnecessaryIf"
    final val UnnecessaryReturnUse = "UnnecessaryReturnUse"
    final val UnreachableCatch = "UnreachableCatch"
    final val UnsafeContains = "UnsafeContains"
    final val UnsafeStringContains = "UnsafeStringContains"
    final val UnsafeTraversableMethods = "UnsafeTraversableMethods"
    final val UnusedMethodParameter = "UnusedMethodParameter"
    final val UseCbrt = "UseCbrt"
    final val UseExpM1 = "UseExpM1"
    final val UseLog10 = "UseLog10"
    final val UseLog1P = "UseLog1P"
    final val UseSqrt = "UseSqrt"
    final val VarClosure = "VarClosure"
    final val VarCouldBeVal = "VarCouldBeVal"
    final val VariableShadowing = "VariableShadowing"
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
    // http://github.com/wartremover/wartremover
    final val Any = "org.wartremover.warts.Any"
    final val AnyVal = "org.wartremover.warts.AnyVal"
    final val ArrayEquals = "org.wartremover.warts.ArrayEquals"
    final val AsInstanceOf = "org.wartremover.warts.AsInstanceOf"
    final val DefaultArguments = "org.wartremover.warts.DefaultArguments"
    final val EitherProjectionPartial = "org.wartremover.warts.EitherProjectionPartial"
    final val Enumeration = "org.wartremover.warts.Enumeration"
    final val Equals = "org.wartremover.warts.Equals"
    final val ExplicitImplicitTypes = "org.wartremover.warts.ExplicitImplicitTypes"
    final val FinalCaseClass = "org.wartremover.warts.FinalCaseClass"
    final val FinalVal = "org.wartremover.warts.FinalVal"
    final val ImplicitConversion = "org.wartremover.warts.ImplicitConversion"
    final val ImplicitParameter = "org.wartremover.warts.ImplicitParameter"
    final val IsInstanceOf = "org.wartremover.warts.IsInstanceOf"
    final val JavaConversions = "org.wartremover.warts.JavaConversions"
    final val JavaSerializable = "org.wartremover.warts.JavaSerializable"
    final val LeakingSealed = "org.wartremover.warts.LeakingSealed"
    final val MutableDataStructures = "org.wartremover.warts.MutableDataStructures"
    final val NonUnitStatements = "org.wartremover.warts.NonUnitStatements"
    final val Nothing = "org.wartremover.warts.Nothing"
    final val Null = "org.wartremover.warts.Null"
    final val Option2Iterable = "org.wartremover.warts.Option2Iterable"
    final val OptionPartial = "org.wartremover.warts.OptionPartial"
    final val Overloading = "org.wartremover.warts.Overloading"
    final val Product = "org.wartremover.warts.Product"
    final val PublicInference = "org.wartremover.warts.PublicInference"
    final val Recursion = "org.wartremover.warts.Recursion"
    final val Return = "org.wartremover.warts.Return"
    final val Serializable = "org.wartremover.warts.Serializable"
    final val StringPlusAny = "org.wartremover.warts.StringPlusAny"
    final val Throw = "org.wartremover.warts.Throw"
    final val ToString = "org.wartremover.warts.ToString"
    final val TraversableOps = "org.wartremover.warts.TraversableOps"
    final val TryPartial = "org.wartremover.warts.TryPartial"
    final val Var = "org.wartremover.warts.Var"
    final val While = "org.wartremover.warts.While"

    // http://github.com/wartremover/wartremover-contrib/
    final val Apply = "org.wartremover.contrib.warts.Apply"
    final val DiscardedFuture = "org.wartremover.contrib.warts.DiscardedFuture"
    final val ExposedTuples = "org.wartremover.contrib.warts.ExposedTuples"
    final val MissingOverride = "org.wartremover.contrib.warts.MissingOverride"
    final val NoNeedImport = "org.wartremover.contrib.warts.NoNeedImport"
    final val OldTime = "org.wartremover.contrib.warts.OldTime"
    final val RefinedClasstag = "org.wartremover.contrib.warts.RefinedClasstag"
    final val SealedCaseClass = "org.wartremover.contrib.warts.SealedCaseClass"
    final val SomeApply = "org.wartremover.contrib.warts.SomeApply"
    final val SymbolicName = "org.wartremover.contrib.warts.SymbolicName"
    final val UnintendedLaziness = "org.wartremover.contrib.warts.UnintendedLaziness"
    final val UnsafeInheritance = "org.wartremover.contrib.warts.UnsafeInheritance"

    // http://github.com/danielnixon/extrawarts
    final val EnumerationPartial = "org.danielnixon.extrawarts.EnumerationPartial"
    final val FutureObject = "org.danielnixon.extrawarts.FutureObject"
    final val GenMapLikePartial = "org.danielnixon.extrawarts.GenMapLikePartial"
    final val GenTraversableLikeOps = "org.danielnixon.extrawarts.GenTraversableLikeOps"
    final val GenTraversableOnceOps = "org.danielnixon.extrawarts.GenTraversableOnceOps"
    final val ScalaGlobalExecutionContext = "org.danielnixon.extrawarts.ScalaGlobalExecutionContext"
    final val StringOpsPartial = "org.danielnixon.extrawarts.StringOpsPartial"
    final val ThrowablePartial = "org.danielnixon.extrawarts.ThrowablePartial"
    final val TraversableOnceOps = "org.danielnixon.extrawarts.TraversableOnceOps"
  }
}
