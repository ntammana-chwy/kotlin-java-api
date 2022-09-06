output "lambda-arn" {
  description = "Lambda arn"
  value       = aws_lambda_function.test_lambda.arn
}