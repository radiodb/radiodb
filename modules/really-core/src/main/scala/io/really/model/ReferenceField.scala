/**
 * Copyright (C) 2014-2015 Really Inc. <http://really.io>
 */
package io.really.model

import _root_.io.really.R
import play.api.libs.json._

case class ReferenceField(
    key: FieldKey,
    required: Boolean,
    collectionR: R,
    fields: List[FieldKey]) extends Field[R] {

  val dataType = DataType.Reference

  override def read(root: JsPath, input: JsObject): JsResult[JsObject] = {
    //todo check that R is actually an object, not a collection
    val path = root \ key
    ((input \ key).toOption, required) match {
      case (None, true) =>
        JsError(path, "value.required")
      case (None, false) =>
        JsSuccess(Json.obj(key -> JsNull), path)
      case (Some(v), _) =>
        v.validate[R] match {
          case JsSuccess(v, _) if (v.skeleton == collectionR) =>
            JsSuccess(Json.obj(key -> v), path)
          case _ =>
            JsError(path, "error.invalid.R")
        }
    }
  }

  //todo define reference field writes
}
