terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
  }

  backend "s3" {}

  required_version = ">= 1.2.0"
}

provider "aws" {
  region = "us-east-1"
}

data "aws_iam_role" "test-role" {
  name = "test_role"
}

resource "aws_lambda_function" "test_lambda" {
  filename      = "lambda-${var.git_hash}.jar"
  function_name = "${var.environment}-test-lambda"
  role          = data.aws_iam_role.test-role.arn
  handler       = "com.learning.lambda.RequestHandler"
  runtime       = "java11"
  memory_size   = 2048

  ephemeral_storage {
    size = 10240 # Min 512 MB and the Max 10240 MB
  }
}