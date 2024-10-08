/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.emv.qrcode.validators.mpm;

import br.com.fluentvalidator.AbstractValidator;
import com.emv.qrcode.model.mpm.PaymentSystemSpecificTemplate;

import static br.com.fluentvalidator.function.FunctionBuilder.of;
import static br.com.fluentvalidator.predicate.ComparablePredicate.betweenInclusive;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeBetween;

// @formatter:off
class PaymentSystemSpecificTemplateValidator extends AbstractValidator<PaymentSystemSpecificTemplate> {

  private final String tagStart;
  private final String tagEnd;
  private final Integer maxSizeValue;

  public PaymentSystemSpecificTemplateValidator(final String tagStart, final String tagEnd, final Integer maxSizeValue) {
    this.tagStart = tagStart;
    this.tagEnd = tagEnd;
    this.maxSizeValue = maxSizeValue;
  }

  @Override
  public void rules() {

    ruleFor("PaymentSystemSpecificTemplate", PaymentSystemSpecificTemplate::getTag)
      .must(betweenInclusive(tagStart, tagEnd))
      .critical();

    ruleFor("PaymentSystemSpecificTemplate", of(PaymentSystemSpecificTemplate::getValue))
      .must(stringSizeBetween(1, maxSizeValue))
      .critical();
  }

}
// @formatter:on
