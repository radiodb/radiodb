package io.really.js

class SDKException(message: String) extends RuntimeException(message)

class InternalSDKException(message: String) extends SDKException(message)

