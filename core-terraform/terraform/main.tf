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

resource "aws_lambda_function" "test_lambda" {
  filename      = "lambda_function_payload.zip"
  function_name = "${var.environment}-test-lambda"
  role          = "arn:aws:iam::496721647268:role/test_role"
  handler       = "RequestHandler"
  runtime       = "java11"

  ephemeral_storage {
    size = 10240 # Min 512 MB and the Max 10240 MB
  }
}

resource "aws_dynamodb_table" "learning-db" {
  name           = "${var.environment}-learning-db"
  billing_mode   = "PROVISIONED"
  read_capacity  = 20
  write_capacity = 20
  hash_key       = "pk"
  range_key      = "sk"
  attribute {
    name = "pk"
    type = "S"
  }

  attribute {
    name = "sk"
    type = "S"
  }

  tags = {
    Name        = "learning"
    Environment = "testing"
  }
}