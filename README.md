# Web Test Automation Framework

A modern, scalable web test automation framework built with Kotlin, Playwright, and JUnit 5. This project demonstrates a component-based architecture for UI testing across multiple layers of a software product.

## 🚀 Features

- **Unified Testing Platform**: Single Kotlin codebase for backend, web, and mobile testing
- **Component-Based Architecture**: Hierarchical structure (Components → Blocks → Pages)
- **Modern Tools**: Playwright for reliable browser automation
- **Type Safety**: Kotlin's null safety and immutability features
- **Factory Pattern**: Dynamic page creation with configurable navigation
- **Wait Strategies**: Built-in smart waiting mechanisms for stable tests

## 🏗️ Architecture

### Core Components
- **Components**: Reusable UI elements (Button, Input, Link, Text, etc.)
- **Blocks**: Page sections (Header, Content, Footer)
- **Pages**: Complete web pages with navigation logic
- **Factories**: Dynamic page instance creation

### Project Structure

    src/test/kotlin/  
    ├── component/ # UI components  
    ├── block/ # Page blocks  
    ├── page/ # Page objects and factories  
    ├── extension/ # Kotlin extensions  
    ├── config/ # Playwright configuration  
    └── test/ # Test cases  