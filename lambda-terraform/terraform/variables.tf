variable "instance_name" {
  description = "Value of the Name tag for the EC2 instance"
  type        = string
  default     = "YetAnotherName"
}

variable "environment" {
  description = "The Chewy environment this resource will be deployed in: qat, stg, prd."
}

variable "git_hash" {
  description = "Github Commit Hash"
}